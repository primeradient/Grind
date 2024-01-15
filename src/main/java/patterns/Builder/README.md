<h2>Builder</h2>
<b>Type:</b> Creational Pattern
<br>

Build a complex object with lot of parameters. Example a MacD Menu

<pre>
        Builder builder = new Builder();
        Meal veg = builder.createVegMeal();
        System.out.println("Veg Meal Price: " + veg.getPrice());
</pre>