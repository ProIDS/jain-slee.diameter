/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
package net.java.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Service-Generic-Information grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.2.0) specification:
 * <pre>
 * The Service-Generic-Information AVP (AVP code 1256) is of type Grouped. Its purpose is to allow the transmission of service information elements used for all services.
 * The OMA specific use is defined at OMNA WSP Content Type Codes database [210].
 * It has the following ABNF grammar:
 *
 *  Service-Generic-Information ::= < AVP Header: 1256 >
 *      [ Application-Server-ID ]
 *      [ Application-Service-Type ]
 *      [ Application-Session-ID ]
 *      [ Delivery-Status ]
 * </pre>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public interface ServiceGenericInformation extends GroupedAvp {

    /**
     * Returns the value of the Application-Server-ID AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    abstract long getApplicationServerID();

    /**
     * Returns the value of the Application-Service-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    abstract ApplicationServiceType getApplicationServiceType();

    /**
     * Returns the value of the Application-Session-ID AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    abstract long getApplicationSessionId();

    /**
     * Returns the value of the Delivery-Status AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    abstract String getDeliveryStatus();


    /**
     * Returns true if the Application-Server-ID AVP is present in the message.
     */
    abstract boolean hasApplicationServerId();

    /**
     * Returns true if the Application-Service-Type AVP is present in the message.
     */
    abstract boolean hasApplicationServiceType();

    /**
     * Returns true if the Application-Session-ID AVP is present in the message.
     */
    abstract boolean hasApplicationSessionId();

    /**
     * Returns true if the Delivery-Status AVP is present in the message.
     */
    abstract boolean hasDeliveryStatus();


    /**
     * Sets the value of the Application-Server-ID AVP, of type Unsigned32.
     */
    abstract void setApplicationServerId(long applicationServerId);

    /**
     * Sets the value of the Application-Service-Type AVP, of type Enumerated.
     */
    abstract void setApplicationServiceType(ApplicationServiceType applicationServiceType);

    /**
     * Sets the value of the Application-Session-ID AVP, of type Unsigned32.
     */
    abstract void setApplicationSessionId(long applicationSessionId);

    /**
     * Sets the value of the Delivery-Status AVP, of type UTF8String.
     */
    abstract void setDeliveryStatus(String deliveryStatus);


}
