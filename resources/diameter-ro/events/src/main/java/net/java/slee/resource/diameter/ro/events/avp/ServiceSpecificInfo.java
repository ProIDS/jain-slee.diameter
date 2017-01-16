/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Service-Specific-Info grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.25.0) specification
 * <pre>
 *  7.2.151	Service-Specific-Info AVP
 * The Service-Specific-Info AVP (AVP Code 1249) is of type Grouped and holds service specific data if and as provided by an Application Server or a PCEF only for pre-defined PCC rules.
 *
 * It has the following ABNF grammar:
 * Service-Specific-Info  ::=	   < AVP Header: 1249 >
 *      [ Service-Specific-Data ]
 *      [ Service-Specific-Type ]
 *  </pre>
 *  
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public interface ServiceSpecificInfo extends GroupedAvp {

    /**
     * Returns the value of the Service-Specific-Data AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    abstract String getServiceSpecificData();

    /**
     * Returns the value of the Service-Specific-Type AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    abstract long getServiceSpecificType();


    /**
     * Returns true if the Service-Specific-Data AVP is present in the message.
     */
    abstract boolean hasServiceSpecificData();

    /**
     * Returns true if the Service-Specific-Type AVP is present in the message.
     */
    abstract boolean hasServiceSpecificType();


    /**
     * Sets the value of the Service-Specific-Data AVP, of type UTF8String.
     */
    abstract void setServiceSpecificData(String serviceSpecificData);

    /**
     * Sets the value of the Service-Specific-Type AVP, of type Unsigned32.
     */
    abstract void setServiceSpecificType(long serviceSpecificType);

}
