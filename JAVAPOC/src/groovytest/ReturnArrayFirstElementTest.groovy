package groovytest

class ReturnArrayFirstElementTest {
	
	
	static main(args) {
		println "names are >> "+listOfName()[2]
	}
	
	static def listOfName(){
		println "from listofnames";
		def birdArr = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		birdArr;
	}
}
