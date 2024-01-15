package patterns.AbstractFactory;


interface Window {
    public void setTitle(String title);
}


class MSWindow implements Window {
    String title;

    public void setTitle(String title) {
        this.title = "MS-" + title;
    }
}

class OSXWindow implements Window {
    String title;

    public void setTitle(String title) {
        this.title = "OSX-" + title;
    }
}


interface AbstractWidgetFactory {
    public Window createWindow();
}

class OSXWidgetFactory implements AbstractWidgetFactory {
    public Window createWindow() {
        return new OSXWindow();
    }
}


class MSWidgetFactory implements AbstractWidgetFactory {
    public MSWindow createWindow() {
        return new MSWindow();
    }
}

class GUIBuilder {
    public void buildWindow(AbstractWidgetFactory widgetFactory ) {
        Window window = widgetFactory.createWindow();
        window.setTitle("MyWindow");
    }
}

public class Main {
    public static void main(String agrs[]) {
        String osName = System.getProperty("os.name");

        AbstractWidgetFactory widgetFactory = null;

        if ( osName.equals("Mac OS X")) {
            widgetFactory = new OSXWidgetFactory();
        } else {
            widgetFactory = new MSWidgetFactory();
        }

        GUIBuilder guiBuilder = new GUIBuilder();
        guiBuilder.buildWindow(widgetFactory);

    }
}