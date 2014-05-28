
package com.cdyne.wsf;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Weather", targetNamespace = "http://ws.cdyne.com/WeatherWS/", wsdlLocation = "http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl")
public class Weather
    extends Service
{

    private final static URL WEATHER_WSDL_LOCATION;
    private final static WebServiceException WEATHER_EXCEPTION;
    private final static QName WEATHER_QNAME = new QName("http://ws.cdyne.com/WeatherWS/", "Weather");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEATHER_WSDL_LOCATION = url;
        WEATHER_EXCEPTION = e;
    }

    public Weather() {
        super(__getWsdlLocation(), WEATHER_QNAME);
    }

    public Weather(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEATHER_QNAME, features);
    }

    public Weather(URL wsdlLocation) {
        super(wsdlLocation, WEATHER_QNAME);
    }

    public Weather(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEATHER_QNAME, features);
    }

    public Weather(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Weather(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WeatherSoap
     */
    @WebEndpoint(name = "WeatherSoap")
    public WeatherSoap getWeatherSoap() {
        return super.getPort(new QName("http://ws.cdyne.com/WeatherWS/", "WeatherSoap"), WeatherSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherSoap
     */
    @WebEndpoint(name = "WeatherSoap")
    public WeatherSoap getWeatherSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.cdyne.com/WeatherWS/", "WeatherSoap"), WeatherSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WeatherSoap
     */
    @WebEndpoint(name = "WeatherSoap12")
    public WeatherSoap getWeatherSoap12() {
        return super.getPort(new QName("http://ws.cdyne.com/WeatherWS/", "WeatherSoap12"), WeatherSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherSoap
     */
    @WebEndpoint(name = "WeatherSoap12")
    public WeatherSoap getWeatherSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.cdyne.com/WeatherWS/", "WeatherSoap12"), WeatherSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WeatherHttpGet
     */
    @WebEndpoint(name = "WeatherHttpGet")
    public WeatherHttpGet getWeatherHttpGet() {
        return super.getPort(new QName("http://ws.cdyne.com/WeatherWS/", "WeatherHttpGet"), WeatherHttpGet.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherHttpGet
     */
    @WebEndpoint(name = "WeatherHttpGet")
    public WeatherHttpGet getWeatherHttpGet(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.cdyne.com/WeatherWS/", "WeatherHttpGet"), WeatherHttpGet.class, features);
    }

    /**
     * 
     * @return
     *     returns WeatherHttpPost
     */
    @WebEndpoint(name = "WeatherHttpPost")
    public WeatherHttpPost getWeatherHttpPost() {
        return super.getPort(new QName("http://ws.cdyne.com/WeatherWS/", "WeatherHttpPost"), WeatherHttpPost.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherHttpPost
     */
    @WebEndpoint(name = "WeatherHttpPost")
    public WeatherHttpPost getWeatherHttpPost(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.cdyne.com/WeatherWS/", "WeatherHttpPost"), WeatherHttpPost.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEATHER_EXCEPTION!= null) {
            throw WEATHER_EXCEPTION;
        }
        return WEATHER_WSDL_LOCATION;
    }

}
