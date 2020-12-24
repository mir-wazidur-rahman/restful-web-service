package com.springlearning.rest.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
	
	
	//URI versioning
	@GetMapping("/v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Mir Rahman");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Mir","Rahman"));
	}
	
	
	//param versioning
	@GetMapping(value = "/param/person",params = "version=1")
	public PersonV1 paramv1() {
		return new PersonV1("Mir Rahman");
	}
	
	@GetMapping(value = "/param/person", params = "version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Mir","Rahman"));
	}
	
	//header versioning
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Mir Rahman");
	}
	
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Mir","Rahman"));
	}
	
	
	//MIME method
	@GetMapping(value = "/person/produces", produces = "application/mir.restapp-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Mir Rahman");
	}
	
	@GetMapping(value = "/person/produces", produces = "application/mir.restapp-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Mir","Rahman"));
	}

}
