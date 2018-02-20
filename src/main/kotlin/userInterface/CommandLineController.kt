package userInterface

import model.Action
import service.KeyValueStoreService
import utils.tail

typealias ActionArgs = List<String>

class CommandLineController(private val keyValueStoreService: KeyValueStoreService) {
    fun start() {
        loop@ while (true){
            val cmd = readLine() ?: ""

            if(cmd.isBlank()) continue

            val (action, args) = parse(cmd)

            when(action) {
                Action.SET -> print(keyValueStoreService.set(args[0], args[1]))
                Action.GET -> print(keyValueStoreService.get(args[0]))
                Action.DEL -> print(keyValueStoreService.del(args[0]))
                Action.EXPIRE -> keyValueStoreService.expire(args[0], args[1].toInt())
                Action.SHUTDOWN -> break@loop
            }
        }

        print("Quit")
    }

    private fun parse(cmd: String): Pair<Action, ActionArgs> {
        val command: List<String> = cmd.split(" ")
        return Action.valueOf(command.first()) to command.tail()
    }
}