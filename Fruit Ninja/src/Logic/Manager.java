package Logic;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Manager {
    public void Command(Command Order) throws TransformerException, ParserConfigurationException {Order.Excute();}
}
