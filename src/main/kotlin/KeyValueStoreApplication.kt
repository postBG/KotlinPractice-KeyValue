import repository.InMemoryKeyValueRepository
import service.KeyValueStoreService
import userInterface.CommandLineController

/*
* [ACTION arg1 arg2 ..]
* SET key value
* GET key
* DEL key
* EXPIRE key seconds
* SHUTDOWN
* */

fun main(args: Array<String>){

    val inMemoryKeyValueRepository = InMemoryKeyValueRepository()
    val keyValueStoreService = KeyValueStoreService(inMemoryKeyValueRepository)
    val commandLineController = CommandLineController(keyValueStoreService)

    commandLineController.start()
}