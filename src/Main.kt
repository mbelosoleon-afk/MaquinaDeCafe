fun main() {
    println("--- Encendiendo la máquina ---")
    CoffeeMachine.makeCoffee()
    CoffeeMachine.clean()

   println("\n--- Intentando hacer café de nuevo ---")
   CoffeeMachine.makeCoffee()

   println("\n--- Limpiando la máquina ---")
   CoffeeMachine.clean()

   println("\n--- Y ahora, otro café ---")
   CoffeeMachine.makeCoffee()
}