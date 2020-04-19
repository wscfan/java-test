package cn.wscfan.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;

import static java.lang.Thread.currentThread;

/**
 * @Author 王松
 * @Date 2020/4/19 21:58
 */
public class XmlTest01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parse = factory.newSAXParser();
        PHandler handler = new PHandler();
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/wscfan/server/basic/p.xml"), handler);
    }
}
class PHandler extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始--->");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "--->解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (content.length() > 0) {
            System.out.println("内容为：" + content);
        } else {
            System.out.println("内容为：" + "空");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "--->解析结束");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("<-----解析文档结束");
    }
}
