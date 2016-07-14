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

package org.mobicents.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.ro.events.avp.DestinationInterface;
import net.java.slee.resource.diameter.ro.events.avp.OriginatorInterface;
import net.java.slee.resource.diameter.ro.events.avp.OriginatorReceivedAddress;
import net.java.slee.resource.diameter.ro.events.avp.RecipientInfo;
import net.java.slee.resource.diameter.ro.events.avp.ReplyPathRequested;
import net.java.slee.resource.diameter.ro.events.avp.SmMessageType;
import net.java.slee.resource.diameter.ro.events.avp.SmServiceType;
import net.java.slee.resource.diameter.ro.events.avp.SmsInformation;
import net.java.slee.resource.diameter.ro.events.avp.SmsNode;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

import java.util.Date;

/**
 * Implementation of the SMS-Information grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class SmsInformationImpl extends GroupedAvpImpl implements SmsInformation {

  public SmsInformationImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public SmsInformationImpl(int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

    /**
     * Returns the value of the SMS-Node AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    public SmsNode getSmsNode() {
        return (SmsNode) getAvpAsEnumerated(DiameterRoAvpCodes.SMS_NODE, DiameterRoAvpCodes.TGPP_VENDOR_ID, SmsNode.class);
    }

    /**
     * Returns the value of the Client-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    public Address getClientAddress() {
        return getAvpAsAddress(DiameterRoAvpCodes.CLIENT_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Originator-SCCP-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    public Address getOriginatorSccpAddress() {
        return getAvpAsAddress(DiameterRoAvpCodes.ORIGINATOR_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Recipient-SCCP-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    public Address getRecipientSccpAddress() {
        return getAvpAsAddress(DiameterRoAvpCodes.RECIPIENT_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the SMSC-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    public Address getSmscAddress() {
        return getAvpAsAddress(DiameterRoAvpCodes.SMSC_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Data-Coding-Scheme AVP, of type Integer32. A return value 0< implies that the AVP has not been set.
     */
    public int getDataCodingScheme() {
        return getAvpAsInteger32(DiameterRoAvpCodes.DATA_CODING_SCHEME, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Destination-Interface AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    public DestinationInterface getDestinationInterface() {
        return (DestinationInterface) getAvpAsCustom(DiameterRoAvpCodes.DESTINATION_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID, DestinationInterfaceImpl.class);
    }

    /**
     * Returns the value of the SM-Discharge-Time AVP, of type Time. A return value of null implies that the AVP has not been set.
     */
    public Date getSmDischargeTime() {
        return getAvpAsTime(DiameterRoAvpCodes.SM_DISCHARGE_TIME, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the SM-Message-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    public SmMessageType getSmMessageType() {
        return (SmMessageType) getAvpAsEnumerated(DiameterRoAvpCodes.SM_MESSAGE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, SmMessageType.class);
    }

    /**
     * Returns the value of the Originator-Interface AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    public OriginatorInterface getOriginatorInterface() {
        return (OriginatorInterface) getAvpAsCustom(DiameterRoAvpCodes.ORIGINATOR_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID, OriginatorInterfaceImpl.class);
    }

    /**
     * Returns the value of the SM-Protocol-ID AVP, of type OctetString. A return value of null implies that the AVP has not been set.
     */
    public byte[] getSmProtocolId() {
        return getAvpAsOctetString(DiameterRoAvpCodes.SM_PROTOCOL_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Reply-Path-Requested AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    public ReplyPathRequested getReplyPathRequested() {
        return (ReplyPathRequested)getAvpAsEnumerated(DiameterRoAvpCodes.REPLY_PATH_REQUESTED, DiameterRoAvpCodes.TGPP_VENDOR_ID, ReplyPathRequested.class);
    }

    /**
     * Returns the value of the SM-Status AVP, of type OctetString. A return value of null implies that the AVP has not been set.
     */
    public byte[] getSmStatus() {
        return getAvpAsOctetString(DiameterRoAvpCodes.SM_STATUS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the SM-User-Data-Header AVP, of type OctetString. A return value of null implies that the AVP has not been set.
     */
    public byte[] getSmUserDataHeader() {
        return getAvpAsOctetString(DiameterRoAvpCodes.SM_USER_DATA_HEADER, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Number-Of-Messages-Sent AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    public long getNumberOfMessagesSent() {
        return getAvpAsUnsigned32(DiameterRoAvpCodes.NUMBER_OF_MESSAGES_SENT, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the set of Recipient-Info AVPs of type Grouped. The returned array contains the AVPs in the order they appear in the message.
     * A return value of null implies that no AVPs have been set.
     */
    public RecipientInfo[] getRecipientInfos() {
        return (RecipientInfo[]) getAvpsAsCustom(DiameterRoAvpCodes.RECIPIENT_INFO, DiameterRoAvpCodes.TGPP_VENDOR_ID, RecipientInfoImpl.class);
    }

    /**
     * Returns the value of the Originator-Received-Address AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    public OriginatorReceivedAddress getOriginatorReceivedAddress() {
        return (OriginatorReceivedAddress) getAvpAsCustom(DiameterRoAvpCodes.ORIGINATOR_RECEIVED_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, OriginatorReceivedAddressImpl.class);
    }

    /**
     * Returns the value of the SM-Service-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    public SmServiceType getSmServiceType() {
        return (SmServiceType) getAvpAsEnumerated(DiameterRoAvpCodes.SM_SERVICE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, SmServiceType.class);
    }

    /**
     * Returns true if the SMS-Node AVP is present in the message.
     */
    public boolean hasSmsNode() {
        return hasAvp( DiameterRoAvpCodes.SMS_NODE, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Client-Address AVP is present in the message.
     */
    public boolean hasClientAddress() {
        return hasAvp( DiameterRoAvpCodes.CLIENT_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Originator-SCCP-Address AVP is present in the message.
     */
    public boolean hasOriginatorSccpAddress() {
        return hasAvp( DiameterRoAvpCodes.ORIGINATOR_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Recipient-SCCP-Address AVP is present in the message.
     */
    public boolean hasRecipientSccpAddress() {
        return hasAvp( DiameterRoAvpCodes.RECIPIENT_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the SMSC-Address AVP is present in the message.
     */
    public boolean hasSmscAddress() {
        return hasAvp( DiameterRoAvpCodes.SMSC_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Data-Coding-Scheme AVP is present in the message.
     */
    public boolean hasDataCodingScheme() {
        return hasAvp( DiameterRoAvpCodes.DATA_CODING_SCHEME, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Destination-Interface AVP is present in the message.
     */
    public boolean hasDestinationInterface() {
        return hasAvp( DiameterRoAvpCodes.DESTINATION_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the SM-Discharge-Time AVP is present in the message.
     */
    public boolean hasSmDischargeTime() {
        return hasAvp( DiameterRoAvpCodes.SM_DISCHARGE_TIME, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the SM-Message-Type AVP is present in the message.
     */
    public boolean hasSmMessageType() {
        return hasAvp( DiameterRoAvpCodes.SM_MESSAGE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Originator-Interface AVP is present in the message.
     */
    public boolean hasOriginatorInterface() {
        return hasAvp( DiameterRoAvpCodes.ORIGINATOR_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the SM-Protocol-ID AVP is present in the message.
     */
    public boolean hasSmProtocolId() {
        return hasAvp( DiameterRoAvpCodes.SM_PROTOCOL_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Reply-Path-Requested AVP is present in the message.
     */
    public boolean hasReplyPathRequested() {
        return hasAvp( DiameterRoAvpCodes.REPLY_PATH_REQUESTED, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the SM-Status AVP is present in the message.
     */
    public boolean hasSmStatus() {
        return hasAvp( DiameterRoAvpCodes.SM_STATUS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the SM-User-Data-Header AVP is present in the message.
     */
    public boolean hasSmUserDataHeader() {
        return hasAvp( DiameterRoAvpCodes.SM_USER_DATA_HEADER, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Number-Of-Messages-Sent AVP is present in the message.
     */
    public boolean hasNumberOfMessagesSent() {
        return hasAvp( DiameterRoAvpCodes.NUMBER_OF_MESSAGES_SENT, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Originator-Received-Address AVP is present in the message.
     */
    public boolean hasOriginatorReceivedAddress() {
        return hasAvp( DiameterRoAvpCodes.ORIGINATOR_RECEIVED_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the SM-Service-Type AVP is present in the message.
     */
    public boolean hasSmServiceType() {
        return hasAvp( DiameterRoAvpCodes.SM_SERVICE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the SMS-Node AVP is present in the message.
     *
     * @param smsNode
     */
    public void setSmsNode(SmsNode smsNode) {
        addAvp(DiameterRoAvpCodes.SMS_NODE, DiameterRoAvpCodes.TGPP_VENDOR_ID, smsNode.getValue());
    }

    /**
     * Returns true if the Client-Address AVP is present in the message.
     *
     * @param clientAddress
     */
    public void setClientAddress(Address clientAddress) {
        addAvp(DiameterRoAvpCodes.CLIENT_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, clientAddress.encode());
    }

    /**
     * Returns true if the Originator-SCCP-Address AVP is present in the message.
     *
     * @param originatorSccpAddress
     */
    public void setOriginatorSccpAddress(Address originatorSccpAddress) {
        addAvp(DiameterRoAvpCodes.ORIGINATOR_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, originatorSccpAddress.encode());
    }

    /**
     * Returns true if the Recipient-SCCP-Address AVP is present in the message.
     *
     * @param recipientSccpAddress
     */
    public void setRecipientSccpAddress(Address recipientSccpAddress) {
        addAvp(DiameterRoAvpCodes.RECIPIENT_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, recipientSccpAddress.encode());
    }

    /**
     * Returns true if the SMSC-Address AVP is present in the message.
     *
     * @param smscAddress
     */
    public void setSmscAddress(Address smscAddress) {
        addAvp(DiameterRoAvpCodes.SMSC_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, smscAddress.encode());
    }

    /**
     * Returns true if the Data-Coding-Scheme AVP is present in the message.
     *
     * @param dataCodingScheme
     */
    public void setDataCodingScheme(int dataCodingScheme) {
        addAvp(DiameterRoAvpCodes.DATA_CODING_SCHEME, DiameterRoAvpCodes.TGPP_VENDOR_ID, dataCodingScheme);
    }

    /**
     * Returns true if the Destination-Interface AVP is present in the message.
     *
     * @param destinationInterface
     */
    public void setDestinationInterface(DestinationInterface destinationInterface) {
        addAvp(DiameterRoAvpCodes.DESTINATION_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID, destinationInterface.byteArrayValue());
    }

    /**
     * Returns true if the SM-Discharge-Time AVP is present in the message.
     *
     * @param smDischargeTime
     */
    public void setSmDischargeTime(Date smDischargeTime) {
        addAvp(DiameterRoAvpCodes.SM_DISCHARGE_TIME, DiameterRoAvpCodes.TGPP_VENDOR_ID, smDischargeTime);
    }

    /**
     * Returns true if the SM-Message-Type AVP is present in the message.
     *
     * @param smMessageType
     */
    public void setSmMessageType(SmMessageType smMessageType) {
        addAvp(DiameterRoAvpCodes.SM_MESSAGE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, smMessageType.getValue());
    }

    /**
     * Returns true if the Originator-Interface AVP is present in the message.
     *
     * @param originatorInterface
     */
    public void setOriginatorInterface(OriginatorInterface originatorInterface) {
        addAvp(DiameterRoAvpCodes.ORIGINATOR_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID, originatorInterface.byteArrayValue());
    }

    /**
     * Returns true if the SM-Protocol-ID AVP is present in the message.
     *
     * @param smProtocolId
     */
    public void setSmProtocolId(byte[] smProtocolId) {
        addAvp(DiameterRoAvpCodes.SM_PROTOCOL_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, smProtocolId);
    }

    /**
     * Returns true if the Reply-Path-Requested AVP is present in the message.
     *
     * @param replyPathRequested
     */
    public void setReplyPathRequested(ReplyPathRequested replyPathRequested) {
        addAvp(DiameterRoAvpCodes.REPLY_PATH_REQUESTED, DiameterRoAvpCodes.TGPP_VENDOR_ID, replyPathRequested.getValue());
    }

    /**
     * Returns true if the SM-Status AVP is present in the message.
     *
     * @param smStatus
     */
    public void setSmStatus(byte[] smStatus) {
        addAvp(DiameterRoAvpCodes.SM_STATUS, DiameterRoAvpCodes.TGPP_VENDOR_ID, smStatus);
    }

    /**
     * Returns true if the SM-User-Data-Header AVP is present in the message.
     *
     * @param smUserDataHeader
     */
    public void setSmUserDataHeader(byte[] smUserDataHeader) {
        addAvp(DiameterRoAvpCodes.SM_USER_DATA_HEADER, DiameterRoAvpCodes.TGPP_VENDOR_ID, smUserDataHeader);
    }

    /**
     * Returns true if the Number-Of-Messages-Sent AVP is present in the message.
     *
     * @param numberOfMessagesSent
     */
    public void setNumberOfMessagesSent(long numberOfMessagesSent) {
        addAvp(DiameterRoAvpCodes.NUMBER_OF_MESSAGES_SENT, DiameterRoAvpCodes.TGPP_VENDOR_ID, numberOfMessagesSent);
    }

    /**
     * Sets the set of Recipient-Info AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array.
     * Note: the array must not be altered by the caller following this call, and getRecipientInfos() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
     *
     * @param recipientInfos
     */
    public void setRecipientInfos(RecipientInfo[] recipientInfos) {
        for(RecipientInfo recipientInfo : recipientInfos) {
            setRecipientInfo(recipientInfo);
        }
    }

    /**
     * Sets the value of the Recipient-Info AVP, of type Grouped.
     *
     * @param recipientInfo
     */
    public void setRecipientInfo(RecipientInfo recipientInfo) {
        addAvp(DiameterRoAvpCodes.RECIPIENT_INFO, DiameterRoAvpCodes.TGPP_VENDOR_ID, recipientInfo.byteArrayValue());
    }

    /**
     * Sets the value of the Originator-Received-Address AVP, of type Grouped.
     *
     * @param originatorReceivedAddress
     */
    public void setOriginatorReceivedAddress(OriginatorReceivedAddress originatorReceivedAddress) {
        addAvp(DiameterRoAvpCodes.ORIGINATOR_RECEIVED_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, originatorReceivedAddress.byteArrayValue());
    }

    /**
     * Sets the value of the SM-Service-Type AVP, of type Enumerated.
     *
     * @param smServiceType
     */
    public void setSmServiceType(SmServiceType smServiceType) {
        addAvp(DiameterRoAvpCodes.SM_SERVICE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, smServiceType.getValue());
    }

}
