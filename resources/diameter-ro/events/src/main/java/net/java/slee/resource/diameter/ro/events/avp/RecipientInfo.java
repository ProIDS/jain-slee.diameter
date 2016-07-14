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

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Recipient-Info grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.25.0) specification:
 * <pre>
 * The Recipient-Info AVP (AVP code 2026) is of type Grouped. Its purpose is to group information associated with a recipient. and contains the list of Recipient addresses of the message.
 *
 * It has the following ABNF grammar:
 *
 *  Recipient-Info :: = 	< AVP Header: 2026 >
 *       [ Destination-Interface ]
 *     * [ Recipient-Address ]
 *     * [ Recipient-Received-Address ]
 *       [ Recipient-SCCP-Address ]
 *       [ SM-Protocol-ID ]
 *
 *      NOTE 1: This Recipient-Info AVP allows charging for messages with multiple recipients by repeating this AVP for every recipient.
 *              The Recipient-Info AVP unambigiously associates the grouped information to one specific recipient.
 *      NOTE 2: The SM-Protocol-ID AVP only relates to the recipient when charging MT SMS messages as specified in TS 23.040 [216]
 * </pre>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public interface RecipientInfo extends GroupedAvp {

    /**
     * Returns the value of the Destination-Interface AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    abstract DestinationInterface getDestinationInterface();

    /**
     * Returns the set of Recipient-Address AVPs of type Grouped. The returned array contains the AVPs in the order they appear in the message. A return value of null implies that no AVPs have been set.
     */
    abstract RecipientAddress[] getRecipientAddresses();


    /**
     * Returns the set of Recipient-Received-Address AVPs of type Grouped. The returned array contains the AVPs in the order they appear in the message.
     * A return value of null implies that no AVPs have been set.
     */
    abstract RecipientReceivedAddress[] getRecipientReceivedAddresses();

    /**
     * Returns the value of the Recipient-SCCP-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    abstract Address getRecipientSccpAddress();

    /**
     * Returns the value of the SM-Protocol-ID AVP, of type OctetString. A return value of null implies that the AVP has not been set.
     */
    abstract byte[] getSmProtocolId();


    /**
     * Returns true if the Destination-Interface AVP is present in the message.
     */
    abstract boolean hasDestinationInterface();

    /**
     * Returns true if the Recipient-SCCP-Address AVP is present in the message.
     */
    abstract boolean hasRecipientSccpAddress();

    /**
     * Returns true if the SM-Protocol-ID AVP is present in the message.
     */
    abstract boolean hasSmProtocolId();


    /**
     * Sets the value of the Destination-Interface AVP, of type Grouped.
     */
    abstract void setDestinationInterface(DestinationInterface destinationInterface);

    /**
     * Sets the value of the Recipient-Address AVP, of type Grouped.
     */
    abstract void setRecipientAddress(RecipientAddress recipientAddress);

    /**
     * Sets the set of Recipient-Address AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array.
     * Note: the array must not be altered by the caller following this call, and getRecipientAddresses() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
     */
    abstract void setRecipientAddresses(RecipientAddress[] recipientAddresses);

    /**
     * Sets the value of the Recipient-Received-Address AVP, of type Grouped.
     */
    abstract void setRecipientReceivedAddress(RecipientReceivedAddress recipientReceivedAddress);

    /**
     * Sets the set of Recipient-Received-Address AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array.
     * Note: the array must not be altered by the caller following this call, and getRecipientReceivedAddresses() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
     */
    abstract void setRecipientReceivedAddresses(RecipientReceivedAddress[] recipientReceivedAddresses);

    /**
     * Sets the value of the Recipient-SCCP-Address AVP, of type Address.
     */
    abstract void setRecipientSccpAddress(Address deliveryStatus);

    /**
     * Sets the value of the SM-Protocol-ID AVP, of type OctetString.
     */
    abstract void setSmProtocolId(byte[] smProtocolId);

}
