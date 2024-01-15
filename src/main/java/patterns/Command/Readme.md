<h1>Command Pattern</h2>
<b>Type: </b> Behavioural Pattern<br>


<ul>
<li>Requester of action is decoupled from performer of action
<li>Request is an Object which is passed to performer of action on request.
<li>This pattern has a Receiver-Action Pair
<li>Example: Light Switch
    <ul>
    <li>Switch has instance of lightOnCommand.
    <li>LightOnCommand has instance of Light (lightOnCommand knows how to switch on a light)
    <li>Switch.On() => lightOnCommand.execute() => Light.switchOn();
    </ul>
</ul>




