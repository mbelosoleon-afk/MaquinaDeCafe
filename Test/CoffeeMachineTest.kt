import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CoffeeMachineTest {

    @Test
    fun makeCoffeeTransitionsFromIdleToServingCoffee() {
        CoffeeMachine.currentState = CoffeeMachine.estadoIdle
        CoffeeMachine.makeCoffee()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.ServingCoffee)
    }

    @Test
    fun makeCoffeeWhileMakingCoffeeDoesNotChangeState() {
        CoffeeMachine.currentState = CoffeeMachineState.MakingCoffee
        CoffeeMachine.makeCoffee()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.MakingCoffee)
    }

    @Test
    fun makeCoffeeWhileServingCoffeeDoesNotChangeState() {
        CoffeeMachine.currentState = CoffeeMachineState.ServingCoffee("Nescafé")
        CoffeeMachine.makeCoffee()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.ServingCoffee)
    }

    @Test
    fun makeCoffeeWithErrorStateDoesNotChangeState() {
        CoffeeMachine.currentState = CoffeeMachineState.Error("Error de prueba")
        CoffeeMachine.makeCoffee()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.Error)
    }

    @Test
    fun cleanResetsStateToIdle() {
        CoffeeMachine.currentState = CoffeeMachineState.Error("Error de prueba")
        CoffeeMachine.clean()
        assertTrue(CoffeeMachine.currentState is CoffeeMachineState.Idle)
    }
}