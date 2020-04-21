package cn.wscfan.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王松
 * @Date 2020/4/19 21:58
 */
public class XmlTest02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parse = factory.newSAXParser();
        PersonHandler handler = new PersonHandler();
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/wscfan/server/basic/p.xml"), handler);

        // 获取数据
        List<Person> persons = handler.getPersons();
        for (Person p: persons) {
            System.out.println(p.getName() + "---->" + p.getAge());
        }
    }
}

class PersonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    private String tag; // 存储操作的标签
    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "--->解析开始");
        if (null != qName) {
            tag = qName;
        }
        if (tag.equals("person")) {
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (null != tag) {
            if (tag.equals("name")) {
                person.setName(contents);
            } else if (tag.equals("age")) {
                if (tag.length() > 0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "--->解析结束");
        if (qName != tag) {
            if (qName.equals("person")) {
                persons.add(person);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
    }

    public List<Person> getPersons() {
        return persons;
    }
}
