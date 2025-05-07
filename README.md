**07.05.2025**:<br>
This is the first entry which had been overdue for quite some time. This is supposed to be a very flexible MathLibrary
with LaTeX support.<br>

I'll try to summarize everything that I have  accomplished so far. I created the Interface [Expression][expr] with the 
methods:

    public String get();

    public boolean isZero();

    public boolean isPositive();

    public Expression add(Expression v);

    public Expression sub(Expression v);

    public Expression mul(Expression v);

    public Expression div(Expression v);

    public void optimize();

    public void checkIntegrity();

    public void setPrefix(String prefix);

    public void setSuffix(String suffix);

    public String getPrefix();

    public String getSuffix();

In addition, there is the class [**ExpressionModifier**][expr_mod] implementing the [**Expression**][expr] interface. 
This class is then used by other classes such as [**Number**][numb], [**Fraction**][frac], [**SquareRoot**][squar], 
[**Polynom**][poly] and [**Value**][value]. All the classes also use the Expression to make it obvious, that they all 
have those methods  available. Not all the methods have their own implementations if they're not needed. A Number for 
example doesn't have its own integrity while a Fraction isn't allowed to have 0 as a denominator. It is also ensured, 
that whenever a mathematical operation is executed that a new object will be created representing the correct 
mathematical object with correct solution.<br>

I also created two classes for LaTeX support. Firstly [**LatexParser**][latex_parser] and secondly 
[**LatexParseManager**][latex_manager]. The LatexParser can parse the mathematical objects into LaTeX without knowing 
anything about them directly. For example: For parsing a Fraction the LatexParser  expects a String numerator, a String 
denominator, the information if the fraction is supposed to be negative as a  boolean, a String  prefix and a String 
suffix. For parsing Number it expects a String number, a String prefix  and a String suffix. The information needed is 
supplied by LatexParseManager. This class is the bridge among the mathematical objects the LatexParser.

A big selling point is, that you can combine the mathematical objects however you like. A Fraction consists of 
Expressions, so does a Polynom. Yet the LatexParseManager can parse it correctly offering a lot of flexibility.

[expr]: src/values/Expression.java
[expr_mod]: src/values/ExpressionModifier.java
[numb]: src/values/Number.java
[frac]: src/values/Fraction.java
[squar]: src/values/SquareRoot.java
[poly]: src/values/Polynom.java
[value]: src/values/Value.java

[latex_manager]: src/latex/LatexParseManager.java
[latex_parser]: src/latex/LatexParser.java