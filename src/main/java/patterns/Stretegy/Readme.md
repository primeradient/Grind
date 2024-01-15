<h2>Strategy</h2>
<b>Type:</b>Behavioral Pattern
<br><br>


<ul>
<li>Change Algorithm at run time
<li>Create Objects which represents various Strategies
<li>Create Context object whose behaviour changes according to strategy
<li>Example: ADD, MUL, DIV, SUB are strategy for a context
<pre>
        Context context = new Context();

        context.execute(new ADD(5,6));

        context.execute(new SUB(5,6));
</pre>
</ul>