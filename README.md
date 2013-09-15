validation
==========

A simple general purpose validation framework

The framework provides some interfaces and classes to implement validators for java objects. The validation results are 
added to a reusable context, which also provides an area to add validation properties and hints.

Hints may be used to pass objects to validators, that are expensive to create, like resolved entities from databases or parsed files. Validators then can use those objects rather then creating them again.

Validators simply implement the Validator interface and add a validation result to the context.
