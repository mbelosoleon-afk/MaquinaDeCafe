fun main() {
    while(true){
        CoffeeMachine.makeCoffee()
        if(CoffeeMachine.currentState is CoffeeMachineState.EcharCafe){
            CoffeeMachine.makeCoffee()
            break
        }
    }
}