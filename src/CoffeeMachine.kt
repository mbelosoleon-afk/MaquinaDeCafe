import java.util.Scanner

object CoffeeMachine {
        var estadoIdle = CoffeeMachineState.Idle()
        public var currentState: CoffeeMachineState = estadoIdle

        fun makeCoffee() {
            println("Estado actual: $currentState")

            when (currentState) {
                is CoffeeMachineState.Idle -> {
                    println("Esperando")
                    currentState = CoffeeMachineState.Menu
                }
                is CoffeeMachineState.EcharCafe -> {
                    println("Echando café...")
                    return
                }
                is CoffeeMachineState.Menu -> {
                    val scann: Scanner = Scanner(System.`in`)
                    println("1.Echar Leche")
                    println("2.Calentar agua")
                    var opcion = listOf(1,2).random()
                    when(opcion){
                        1 -> currentState = CoffeeMachineState.EcharLeche
                        2 -> currentState = CoffeeMachineState.CalentarAgua
                    }
                }
                is CoffeeMachineState.CalentarAgua -> {
                    println("Calentando agua...")
                    currentState = CoffeeMachineState.EcharCafe
                }
                is CoffeeMachineState.Error -> {
                    println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
                }
                is CoffeeMachineState.EcharAzucar -> {
                    println("Echando azucar")
                    currentState = CoffeeMachineState.CalentarAgua
                }
                is CoffeeMachineState.EcharLeche -> {
                    println("Echando leche")
                    var scann = listOf(1,2).random()
                    when(scann) {
                        1 -> currentState = CoffeeMachineState.EcharAzucar(true)
                        2 -> currentState = CoffeeMachineState.CalentarAgua
                    }
                }
            }
        }

        fun clean() {
            println("Limpiando la máquina...")
            currentState = estadoIdle
            println("Máquina limpia. Estado: $currentState")
        }
    }

