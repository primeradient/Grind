<h2>Abstract Factory</h2>
<b>Type:</b>Creational Pattern
<br>
<ul>
<li>A Super factory creates other factories
</ul>

<b>Example:</b> A GUI across platforms. Initilize the GUI based on Windows or OSX. Then based on detected platform, create
platform dependent Windows, Panes, Buttons and so on.


<pre>
1. Create an AbstractFactory instance  (based on platform, returns relevent Factory Object)
2. Create a Builder
3. Call Builder to create a new Window by passing abstractFactory instance.
   Abstract factory should take care of what concrete factory to build. 
   Each concrete factory houses further component factories.

           AbstractWidgetFactory widgetFactory = null;

           if ( osName.equals("Mac OS X")) {
               widgetFactory = new OSXWidgetFactory();
           } else {
               widgetFactory = new MSWidgetFactory();
           }

           GUIBuilder guiBuilder = new GUIBuilder();
           guiBuilder.buildWindow(widgetFactory);

</pre>
