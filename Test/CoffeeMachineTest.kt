import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CoffeeMachineTest {

    @Test
    fun makeCoffeeFromIdleTransitionsToCalentarAgua() {
        CoffeeMachine.currentState = CoffeeMachineState.Idle()
        CoffeeMachine.makeCoffee()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.CalentarAgua)
    }

    @Test
    fun makeCoffeeFromEcharCafePrintsReadyAndDoesNotChangeState() {
        CoffeeMachine.currentState = CoffeeMachineState.EcharCafe
        CoffeeMachine.makeCoffee()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.EcharCafe)
    }

    @Test
    fun makeCoffeeFromErrorPrintsErrorAndDoesNotChangeState() {
        val errorState = CoffeeMachineState.Error("Sin agua")
        CoffeeMachine.currentState = errorState
        CoffeeMachine.makeCoffee()
        assertEquals(errorState, CoffeeMachine.currentState)
    }

    @Test
    fun cleanAlwaysTransitionsToIdle() {
        CoffeeMachine.currentState = CoffeeMachineState.EcharAzucar(true)
        CoffeeMachine.clean()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.Idle)
    }


}