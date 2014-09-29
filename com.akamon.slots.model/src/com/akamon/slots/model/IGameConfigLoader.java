package com.akamon.slots.model;

import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: alexander.cohen
 * Date: 9/27/14
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IGameConfigLoader {

    GameConfig loadConfig(InputStream inputStream) throws ParserConfigurationException, Exception;
}
