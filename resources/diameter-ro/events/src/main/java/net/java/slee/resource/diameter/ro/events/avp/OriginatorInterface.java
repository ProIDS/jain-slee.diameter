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
 * Defines an interface representing the Originator-Interface grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.2.0) specification:
 * <pre>
 * The Originator-Interface AVP (AVP code 2009) is the group AVP which contains information related to the Interface on which the message originated.
 * Originator-Interface ::= < AVP Header: 2009 >
 *    [ Interface-Id ]
 *    [ Interface-Text ]
 *    [ Interface-Port ]
 *    [ Interface-Type ]
 * </pre>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public interface OriginatorInterface extends GroupedAvp {

    /**
     * Returns the value of the Interface-Id AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    abstract String getInterfaceId();

    /**
     * Returns the value of the Interface-Text AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    abstract String getInterfaceText();

    /**
     * Returns the value of the Interface-Port AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    abstract String getInterfacePort();

    /**
     * Returns the value of the Interface-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    abstract InterfaceType getInterfaceType();


    /**
     * Returns true if the Interface-Id AVP is present in the message.
     */
    abstract boolean hasInterfaceId();

    /**
     * Returns true if the Interface-Text AVP is present in the message.
     */
    abstract boolean hasInterfaceText();

    /**
     * Returns true if the Interface-Port AVP is present in the message.
     */
    abstract boolean hasInterfacePort();

    /**
     * Returns true if the Interface-Type AVP is present in the message.
     */
    abstract boolean hasInterfaceType();


    /**
     * Sets the value of the Interface-Id AVP, of type UTF8String.
     */
    abstract void setInterfaceId(String interfaceId);

    /**
     * Sets the value of the Interface-Text AVP, of type UTF8String.
     */
    abstract void setInterfaceText(String interfaceText);

    /**
     * Sets the value of the Interface-Port AVP, of type UTF8String.
     */
    abstract void setInterfacePort(String interfacePort);

    /**
     * Sets the value of the Interface-Type AVP, of type Enumerated.
     */
    abstract void setInterfaceType(InterfaceType interfaceType);


}
