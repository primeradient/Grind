<h2>Flyweight</h2>
<b>Type:</b>Structural Pattern
<br><br>

<ul>
<li>Use of shared objects.
<li>Where to use:
   <ol>
   <li>The number of objects created by applications are huge.
   <li>Object creation is heavy on memory and computationally expensive.
   <li>Objects properties can be divided into properties which can be common across instances.
   </ol>
<li>Objects have to be immutable
<li>Example:
<br>Creating Circles. Need is to create multiple circles of difference colors.
<br>By Flyweight, create only one circle for each color and pass it around.
</ul>