# Requirements

## Table of content

- [Table of content](#Table-of-content)
- [Introduction](#Introduction)
- [In Progress](#in-progress)
- [Done](#done)
- [Requirements list](#Requirements-list)
  - [Optimisation for fractions](#Optimisation-for-fractions)
  - [Settings Class for Expression](#Settings-Class-for-Expression)
    - [First idea](#First-ideas)
      - [Settings idea one](#Settings-idea-one)
      - [Settings idea two](#Settings-idea-two)
      - [Settings idea three](#Settings-idea-three)
  - [Expression factory](#Expression-factory)
- [Bugfixes](#bugfixes)
  - [Fix order of operations for number](#fix-order-of-operations-for-number)

## Introduction

This is where I keep my requirements for this project.

## In Progress


## Done
- [Fix order of operations for number](#fix-order-of-operations-for-number)

## Requirements list

### Optimisation for fractions

The expression type fraction does not support being optimized. optimized meaning can we simplify it
somehow.

- [ ] Come up with an idea to do that in an expression environment
- [ ] Should be able to reduce a fraction
- [ ] Should be able to turn fraction to Expression type number

### Settings Class for Expression

It would be useful to give an expression rendering instructions. Setting those manually would be
cumbersome. The idea is to create a settings class that can be passed to an expression. If the expression
then creates a new expression it can be set to automatically pass the settings over to the new one. This
would prevent a lot of complicated logic whenever you combine expressions. 

- [ ] Thinking about a settings model
- [ ] Thinking about how to pass the settings to an expression
- [ ] Create settings class
- [ ] Update expressions


#### First ideas

##### Settings idea one

- Settings class has setters that can be concatenated
- Should render a leading plus
- Should not render ones
- Should automatically optimize
- Should pass settings to newly created expression
- Settings should be passed via the constructors
- There should be a setter for settings
- If no settings object is passed to an expression it will set itself to default settings
- Not all settings make sense for every type of expression which won't be a problem

##### Settings idea two

- Make settings a global state that all expressions use
- Use Singleton pattern for this

##### Settings idea three

- Combine the first and the second idea
- The global state is the default state each expression uses
- If you want an expression to be different you can still set different settings
- Use Singleton pattern for this

### Expression factory

I don't know yet if this will ever make sense, but I'm leaving this here as a reminder

- Use a factory to create expressions to apply settings

## Bugfixes

### Fix order of operations for number

The order of operations for "Number" is wrong. In the case of n1.sub(n2) the result should be
n1 - n2, which is not the case

- [x] Order for all operands is fixed