sealed class CoffeeMachineState {
    class Idle: CoffeeMachineState() {    }
    object Menu: CoffeeMachineState()
    object CalentarAgua: CoffeeMachineState()
    object EcharLeche: CoffeeMachineState()
    data class EcharAzucar(val echar: Boolean): CoffeeMachineState()
    object EcharCafe: CoffeeMachineState()
    data class Error(val message: String): CoffeeMachineState()
}
