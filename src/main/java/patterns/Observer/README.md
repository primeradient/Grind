<b>Name: Observer <br>
Category: Behavioural Pattern<br>
</b>

<b>Usecase:</b> Allows multiple trackers to get status update on Object being tracked.<br>

<b>Example:</b> Stock Market Price Change can be tracked by Stock Traders.<br>

Java Provides Observable and Observer Class to facilitate implementation.<br>

Tracked Objects extend <b>Observable</b> class, and use <b>setChanges()</b> and <b>notifyObsevers()</b> API to notifiy trackers<br>

Trackers implements <b>Observer</b> class and must implement <b>update(Observerable o, Object arg)</b> method to get tracked object.<br>
