import java.util.Scanner

object CoffeeMachine {
        var currentState: CoffeeMachineState = CoffeeMachineState.Idle()

        fun makeCoffee() {
            when (currentState) {
                is CoffeeMachineState.Idle -> {
                    println("Esperando")
                    currentState = CoffeeMachineState.Menu
                }
                is CoffeeMachineState.EcharCafe -> {
                    println("Echando café...")
                    println("Listo")
                    return
                }
                is CoffeeMachineState.Menu -> {
                    println("1.Echar Leche")
                    println("2.Calentar agua")
                    println("Seleccione una")
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
                    var opcion = listOf(1,2).random()
                    when(opcion) {
                        1 -> currentState = CoffeeMachineState.EcharAzucar(true)
                        2 -> currentState = CoffeeMachineState.CalentarAgua
                    }
                }
            }
        }

        fun clean() {
            println("Limpiando la máquina...")
            currentState = CoffeeMachineState.Idle()
            println("Máquina limpia. Estado: $currentState")
        }
    }

