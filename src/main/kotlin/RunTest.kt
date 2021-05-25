
fun main(args : Array<String>) {
    println(args)

    val sampleFetch = SampleFetch()

    sampleFetch.run {
        this.name = "test"
    }

    println(sampleFetch.name)

}
