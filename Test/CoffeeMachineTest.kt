import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CoffeeMachineTest {

    @Test
    fun makeCoffeeFromMenuTransitionsToEcharLecheOrCalentarAgua() {
        CoffeeMachine.currentState = CoffeeMachineState.Menu
        CoffeeMachine.makeCoffee()
        assertTrue(
            CoffeeMachine.currentState is CoffeeMachineState.EcharLeche ||
                    CoffeeMachine.currentState is CoffeeMachineState.CalentarAgua
        )
    }

    @Test
    fun makeCoffeeFromCalentarAguaTransitionsToEcharCafe() {
        CoffeeMachine.currentState = CoffeeMachineState.CalentarAgua
        CoffeeMachine.makeCoffee()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.EcharCafe)
    }

    @Test
    fun makeCoffeeFromEcharAzucarTransitionsToCalentarAgua() {
        CoffeeMachine.currentState = CoffeeMachineState.EcharAzucar(true)
        CoffeeMachine.makeCoffee()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.CalentarAgua)
    }

    @Test
    fun makeCoffeeFromEcharLecheTransitionsToEcharAzucarOrCalentarAgua() {
        CoffeeMachine.currentState = CoffeeMachineState.EcharLeche
        CoffeeMachine.makeCoffee()
        assertTrue(
            CoffeeMachine.currentState is CoffeeMachineState.EcharAzucar ||
                    CoffeeMachine.currentState is CoffeeMachineState.CalentarAgua
        )
    }

}