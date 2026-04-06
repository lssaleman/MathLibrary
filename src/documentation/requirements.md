# Requirements

## Table of content

- [Table of content](#Table-of-content)
- [Introduction](#Introduction)
- [In Progress](#in-progress)
- [Done](#done)
- [Requirements list](#Requirements-list)
  - [Optimisation for fractions with Numbers](#Optimisation-for-fractions-with-numbers)
  - [Settings Class for Number and Fraction](#settings-class-for-number-and-fraction)
  - [Expression factory](#Expression-factory)
  - [Design for Value is needed](#design-for-value-is-needed)
- [Bugfixes](#bugfixes)
  - [Fix order of operations for number](#fix-order-of-operations-for-number)
  - [Fraction class doing optimization without being told so](#fraction-class-doing-optimization-without-being-told-so)

## Introduction

This is where I keep my requirements for this project.

## In Progress
- [Design for Value is needed](#design-for-value-is-needed)

## Done
- [Fix order of operations for number](#fix-order-of-operations-for-number)
- [Settings Class for Number and Fraction](#settings-class-for-number-and-fraction)
- [Optimisation for fractions with Numbers](#Optimisation-for-fractions-with-numbers)

## Requirements list

### Optimisation for fractions with numbers

The expression type fraction does not support being optimized. optimized meaning can we simplify it
somehow.

- [ ] Come up with an idea to do that in an expression environment
- [ ] Should be able to reduce a fraction
- [ ] Should be able to turn fraction to Expression type number

### Settings Class for Number and Fraction

it is useful to give expressions rendering instructions to simplify program logic

- [x] Thinking about a settings model
- [x] Thinking about how to pass the settings to an expression
- [x] Create settings class
- [x] Update Number
- [x] Write Tests for Number
- [x] Update Fraction
- [x] Write Tests for Fraction

#### Implementation

- Created a settings class
- settings class setters return the class itself
- Created a global settings state
- Expressions can be set to have their own settings
  - They can be given an entire setting class
  - Or individual properties can be set
- Possible settings:
  - Render leading plus
  - Render one (vor variables that should not have a leading one)
  - Automatically optimize
  - Pass settings to children

### Expression factory

I don't know yet if this will ever make sense, but I'm leaving this here as a reminder

- Use a factory to create expressions to apply settings

## Bugfixes

### Fix order of operations for number

The order of operations for "Number" is wrong. In the case of n1.sub(n2) the result should be
n1 - n2, which is not the case

- [x] Order for all operands is fixed

### Fraction class doing optimization without being told so

The Fraction simplifies to one if numerator and denominator are equal. This should not automatically
happen

- [x] Remove logic for automated optimization

### Settings Class for Expression Update 1

It would maybe be nice to set settings for specific Expression

### Design for Value is needed

#### First idea

- Values always consist of two expressions
- Values can be in four different states, plus, minus, multiply or subtract
- Values can hold Values since they are expressions themselves

#### Second Idea
- There are four types of values, one already exist being called fraction
- Two can be put together, those two are plus and minus, it just depends on the second expression
- Multiplication is missing as a Value
- Two then need to be freshly implemented