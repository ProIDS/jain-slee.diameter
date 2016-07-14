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

import java.util.Date;

/**
 * Defines an interface representing the SMS-Information grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.25.0) specification:
 * <pre>
 * 7.2.162	SMS-Information AVP
 *     The SMS-Information AVP (AVP code 2000) is of type Grouped. Its purpose is to allow the transmission of additional SMS service specific information elements.
 *     It has the following ABNF grammar:
 *     SMS-Information :: = 	< AVP Header: 2000>
 *         [ SMS-Node ]
 *         [ Client-Address ]
 *         [ Originator-SCCP-Address ]
 *         [ SMSC-Address ]
 *         [ Data-Coding-Scheme ]
 *         [ SM-Discharge-Time ]
 *         [ SM-Message-Type ]
 *         [ Originator-Interface ]
 *         [ SM-Protocol-ID ]
 *         [ Reply-Path-Requested ]
 *         [ SM-Status ]
 *         [ SM-User-Data-Header ]
 *         [ Number-Of-Messages-Sent ]
 *       * [ Recipient-Info ]
 *         [ Originator-Received-Address ]
 *         [ SM-Service-Type ]
 *
 * </pre>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public interface SmsInformation extends GroupedAvp {

  /**
   * Returns the value of the SMS-Node AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
   */
  abstract SmsNode getSmsNode();

  /**
   * Returns the value of the Client-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
   */
  abstract Address getClientAddress();

    /**
     * Returns the value of the Originator-SCCP-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    abstract Address getOriginatorSccpAddress();

    /**
     * Returns the value of the Recipient-SCCP-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    abstract Address getRecipientSccpAddress();

    /**
     * Returns the value of the SMSC-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    abstract Address getSmscAddress();

    /**
     * Returns the value of the Data-Coding-Scheme AVP, of type Integer32. A return value 0< implies that the AVP has not been set.
     */
    abstract int getDataCodingScheme();

    /**
     * Returns the value of the Destination-Interface AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    abstract DestinationInterface getDestinationInterface();

    /**
     * Returns the value of the SM-Discharge-Time AVP, of type Time. A return value of null implies that the AVP has not been set.
     */
    abstract Date getSmDischargeTime();

    /**
     * Returns the value of the SM-Message-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    abstract SmMessageType getSmMessageType();

    /**
     * Returns the value of the Originator-Interface AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    abstract OriginatorInterface getOriginatorInterface();

    /**
     * Returns the value of the SM-Protocol-ID AVP, of type OctetString. A return value of null implies that the AVP has not been set.
     */
    abstract byte[] getSmProtocolId();

    /**
     * Returns the value of the Reply-Path-Requested AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    abstract ReplyPathRequested getReplyPathRequested();

    /**
     * Returns the value of the SM-Status AVP, of type OctetString. A return value of null implies that the AVP has not been set.
     */
    abstract byte[] getSmStatus();

    /**
     * Returns the value of the SM-User-Data-Header AVP, of type OctetString. A return value of null implies that the AVP has not been set.
     */
    abstract byte[] getSmUserDataHeader();

    /**
     * Returns the value of the Number-Of-Messages-Sent AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    abstract long getNumberOfMessagesSent();

    /**
     * Returns the set of Recipient-Info AVPs of type Grouped. The returned array contains the AVPs in the order they appear in the message.
     * A return value of null implies that no AVPs have been set.
     */
    abstract RecipientInfo[] getRecipientInfos();

    /**
     * Returns the value of the Originator-Received-Address AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    abstract OriginatorReceivedAddress getOriginatorReceivedAddress();

    /**
     * Returns the value of the SM-Service-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    abstract SmServiceType getSmServiceType();


    /**
     * Returns true if the SMS-Node AVP is present in the message.
     */
    abstract boolean hasSmsNode();

    /**
     * Returns true if the Client-Address AVP is present in the message.
     */
    abstract boolean hasClientAddress();

    /**
     * Returns true if the Originator-SCCP-Address AVP is present in the message.
     */
    abstract boolean hasOriginatorSccpAddress();

    /**
     * Returns true if the Recipient-SCCP-Address AVP is present in the message.
     */
    abstract boolean hasRecipientSccpAddress();

    /**
     * Returns true if the SMSC-Address AVP is present in the message.
     */
    abstract boolean hasSmscAddress();

    /**
     * Returns true if the Data-Coding-Scheme AVP is present in the message.
     */
    abstract boolean hasDataCodingScheme();

    /**
     * Returns true if the Destination-Interface AVP is present in the message.
     */
    abstract boolean hasDestinationInterface();

    /**
     * Returns true if the SM-Discharge-Time AVP is present in the message.
     */
    abstract boolean hasSmDischargeTime();

    /**
     * Returns true if the SM-Message-Type AVP is present in the message.
     */
    abstract boolean hasSmMessageType();

    /**
     * Returns true if the Originator-Interface AVP is present in the message.
     */
    abstract boolean hasOriginatorInterface();

    /**
     * Returns true if the SM-Protocol-ID AVP is present in the message.
     */
    abstract boolean hasSmProtocolId();

    /**
     * Returns true if the Reply-Path-Requested AVP is present in the message.
     */
    abstract boolean hasReplyPathRequested();

    /**
     * Returns true if the SM-Status AVP is present in the message.
     */
    abstract boolean hasSmStatus();

    /**
     * Returns true if the SM-User-Data-Header AVP is present in the message.
     */
    abstract boolean hasSmUserDataHeader();

    /**
     * Returns true if the Number-Of-Messages-Sent AVP is present in the message.
     */
    abstract boolean hasNumberOfMessagesSent();

    /**
     * Returns true if the Originator-Received-Address AVP is present in the message.
     */
    abstract boolean hasOriginatorReceivedAddress();

    /**
     * Returns true if the SM-Service-Type AVP is present in the message.
     */
    abstract boolean hasSmServiceType();


    /**
     * Returns true if the SMS-Node AVP is present in the message.
     */
    abstract void setSmsNode(SmsNode smsNode);

    /**
     * Returns true if the Client-Address AVP is present in the message.
     */
    abstract void setClientAddress(Address clientAddress);

    /**
     * Returns true if the Originator-SCCP-Address AVP is present in the message.
     */
    abstract void setOriginatorSccpAddress(Address originatorSccpAddress);

    /**
     * Returns true if the Recipient-SCCP-Address AVP is present in the message.
     */
    abstract void setRecipientSccpAddress(Address recipientSccpAddress);

    /**
     * Returns true if the SMSC-Address AVP is present in the message.
     */
    abstract void setSmscAddress(Address smscAddress);

    /**
     * Returns true if the Data-Coding-Scheme AVP is present in the message.
     */
    abstract void setDataCodingScheme(int dataCodingScheme);

    /**
     * Returns true if the Destination-Interface AVP is present in the message.
     */
    abstract void setDestinationInterface(DestinationInterface destinationInterface);

    /**
     * Returns true if the SM-Discharge-Time AVP is present in the message.
     */
    abstract void setSmDischargeTime(Date smDischargeTime);

    /**
     * Returns true if the SM-Message-Type AVP is present in the message.
     */
    abstract void setSmMessageType(SmMessageType smMessageType);

    /**
     * Returns true if the Originator-Interface AVP is present in the message.
     */
    abstract void setOriginatorInterface(OriginatorInterface originatorInterface);

    /**
     * Returns true if the SM-Protocol-ID AVP is present in the message.
     */
    abstract void setSmProtocolId(byte[] smProtocolId);

    /**
     * Returns true if the Reply-Path-Requested AVP is present in the message.
     */
    abstract void setReplyPathRequested(ReplyPathRequested replyPathRequested);

    /**
     * Returns true if the SM-Status AVP is present in the message.
     */
    abstract void setSmStatus(byte[] smStatus);

    /**
     * Returns true if the SM-User-Data-Header AVP is present in the message.
     */
    abstract void setSmUserDataHeader(byte[] userDataHeader);

    /**
     * Returns true if the Number-Of-Messages-Sent AVP is present in the message.
     */
    abstract void setNumberOfMessagesSent(long numberOfMessagesSent);

    /**
     * Sets the set of Recipient-Info AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array.
     * Note: the array must not be altered by the caller following this call, and getRecipientInfos() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
     */
    abstract void setRecipientInfos(RecipientInfo[] recipientInfos);

    /**
     * Sets the value of the Recipient-Info AVP, of type Grouped.
     */
    abstract void setRecipientInfo(RecipientInfo recipientInfo);

    /**
     * Sets the value of the Originator-Received-Address AVP, of type Grouped.
     */
    abstract void setOriginatorReceivedAddress(OriginatorReceivedAddress originatorReceivedAddress);

    /**
     * Sets the value of the SM-Service-Type AVP, of type Enumerated.
     */
    abstract void setSmServiceType(SmServiceType smServiceType);

}
