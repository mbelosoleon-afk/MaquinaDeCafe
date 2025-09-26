sealed class CoffeeMachineState {
    class Idle(val timestamp: Long = System.currentTimeMillis()) : CoffeeMachineState(){
        init {
            println("Estoy en el init del Idle")
        }
    }
    object MakingCoffee : CoffeeMachineState()
    data class ServingCoffee(val brand: String): CoffeeMachineState()
    data class Error(val message: String): CoffeeMachineState()
}
