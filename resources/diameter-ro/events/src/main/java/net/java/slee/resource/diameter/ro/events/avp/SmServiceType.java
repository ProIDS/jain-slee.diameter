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

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.StreamCorruptedException;

import static net.java.slee.resource.diameter.ro.events.avp.SmsNode._SMS_ROUTER;

/**
 * Java class to represent the SmServiceType enumerated type (SM-Service-Type AVP (AVP code 2029) ).
 *             11 .. 99	Reserved for 3GPP defined SM services
 *             100 - 199	Vendor specific SM services
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class SmServiceType implements Enumerated, java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static final int _VAS4SMS_SHORT_MESSAGE_CONTENT_PROCESSING = 0;
    public static final int _VAS4SMS_SHORT_MESSAGE_FORWARDING = 1;
    public static final int _VAS4SMS_SHORT_MESSAGE_FORWARDING_MULTIPLE_SUBSCRIPTIONS = 2;
    public static final int _VAS4SMS_SHORT_MESSAGE_FILTERING = 3;
    public static final int _VAS4SMS_SHORT_MESSAGE_RECEIPT = 4;
    public static final int _VAS4SMS_SHORT_MESSAGE_NETWORK_STORAGE = 5;
    public static final int _VAS4SMS_SHORT_MESSAGE_TO_MULTIPLE_DESTINATIONS = 6;
    public static final int _VAS4SMS_SHORT_MESSAGE_VPN = 7;
    public static final int _VAS4SMS_SHORT_MESSAGE_AUTO_REPLAY = 8;
    public static final int _VAS4SMS_SHORT_MESSAGE_PERSONAL_SIGNATURE = 9;
    public static final int _VAS4SMS_SHORT_MESSAGE_DEFERRED_DELIVERY = 10;

    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_CONTENT_PROCESSING = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_CONTENT_PROCESSING);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_FORWARDING = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_FORWARDING);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_FORWARDING_MULTIPLE_SUBSCRIPTIONS = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_FORWARDING_MULTIPLE_SUBSCRIPTIONS);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_FILTERING = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_FILTERING);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_RECEIPT = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_RECEIPT);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_NETWORK_STORAGE = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_NETWORK_STORAGE);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_TO_MULTIPLE_DESTINATIONS = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_TO_MULTIPLE_DESTINATIONS);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_VPN = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_VPN);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_AUTO_REPLAY = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_AUTO_REPLAY);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_PERSONAL_SIGNATURE = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_PERSONAL_SIGNATURE);
    public static final SmServiceType VAS4SMS_SHORT_MESSAGE_DEFERRED_DELIVERY = new SmServiceType(_VAS4SMS_SHORT_MESSAGE_DEFERRED_DELIVERY);

    public static SmServiceType TGPP_RESERVED;
    public static SmServiceType VENDOR_SPECIFIC;

    private SmServiceType(int v) {
        value = v;
        if(v > 10 && v < 100) {
            TGPP_RESERVED = new SmServiceType(v);
        }
        if (v > 99 && v < 200) {
            VENDOR_SPECIFIC = new SmServiceType(v);
        }
    }

    /**
     * Return the value of this instance of this enumerated type.
     */
    public static SmServiceType fromInt(int type) {
        switch (type) {
            case _VAS4SMS_SHORT_MESSAGE_CONTENT_PROCESSING:
                return VAS4SMS_SHORT_MESSAGE_CONTENT_PROCESSING;
            case _VAS4SMS_SHORT_MESSAGE_FORWARDING:
                return VAS4SMS_SHORT_MESSAGE_FORWARDING;
            case _VAS4SMS_SHORT_MESSAGE_FORWARDING_MULTIPLE_SUBSCRIPTIONS:
                return VAS4SMS_SHORT_MESSAGE_FORWARDING_MULTIPLE_SUBSCRIPTIONS;
            case _VAS4SMS_SHORT_MESSAGE_FILTERING:
                return VAS4SMS_SHORT_MESSAGE_FILTERING;
            case _VAS4SMS_SHORT_MESSAGE_RECEIPT:
                return VAS4SMS_SHORT_MESSAGE_RECEIPT;
            case _VAS4SMS_SHORT_MESSAGE_NETWORK_STORAGE:
                return VAS4SMS_SHORT_MESSAGE_NETWORK_STORAGE;
            case _VAS4SMS_SHORT_MESSAGE_TO_MULTIPLE_DESTINATIONS:
                return VAS4SMS_SHORT_MESSAGE_TO_MULTIPLE_DESTINATIONS;
            case _VAS4SMS_SHORT_MESSAGE_VPN:
                return VAS4SMS_SHORT_MESSAGE_VPN;
            case _VAS4SMS_SHORT_MESSAGE_AUTO_REPLAY:
                return VAS4SMS_SHORT_MESSAGE_AUTO_REPLAY;
            case _VAS4SMS_SHORT_MESSAGE_PERSONAL_SIGNATURE:
                return VAS4SMS_SHORT_MESSAGE_PERSONAL_SIGNATURE;
            case _VAS4SMS_SHORT_MESSAGE_DEFERRED_DELIVERY:
                return VAS4SMS_SHORT_MESSAGE_DEFERRED_DELIVERY;

            default:
                if(type > 10 && type < 100) {
                    TGPP_RESERVED = new SmServiceType(type);
                    return  TGPP_RESERVED;
                }
                if (type > 99 && type < 200) {
                    VENDOR_SPECIFIC = new SmServiceType(type);
                    return  VENDOR_SPECIFIC;
                }
                throw new IllegalArgumentException("Invalid SmServiceType value: " + type);
        }
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        switch (value) {
            case _SMS_ROUTER:
                return "SMS_ROUTER";
            case _VAS4SMS_SHORT_MESSAGE_FORWARDING:
                return "VAS4SMS_SHORT_MESSAGE_FORWARDING";
            case _VAS4SMS_SHORT_MESSAGE_FORWARDING_MULTIPLE_SUBSCRIPTIONS:
                return "VAS4SMS_SHORT_MESSAGE_FORWARDING_MULTIPLE_SUBSCRIPTIONS";
            case _VAS4SMS_SHORT_MESSAGE_FILTERING:
                return "VAS4SMS_SHORT_MESSAGE_FILTERING";
            case _VAS4SMS_SHORT_MESSAGE_RECEIPT:
                return "VAS4SMS_SHORT_MESSAGE_RECEIPT";
            case _VAS4SMS_SHORT_MESSAGE_NETWORK_STORAGE:
                return "VAS4SMS_SHORT_MESSAGE_NETWORK_STORAGE";
            case _VAS4SMS_SHORT_MESSAGE_TO_MULTIPLE_DESTINATIONS:
                return "VAS4SMS_SHORT_MESSAGE_TO_MULTIPLE_DESTINATIONS";
            case _VAS4SMS_SHORT_MESSAGE_VPN:
                return "VAS4SMS_SHORT_MESSAGE_VPN";
            case _VAS4SMS_SHORT_MESSAGE_AUTO_REPLAY:
                return "VAS4SMS_SHORT_MESSAGE_AUTO_REPLAY";
            case _VAS4SMS_SHORT_MESSAGE_PERSONAL_SIGNATURE:
                return "VAS4SMS_SHORT_MESSAGE_PERSONAL_SIGNATURE";
            case _VAS4SMS_SHORT_MESSAGE_DEFERRED_DELIVERY:
                return "_AS4SMS_SHORT_MESSAGE_DEFERRED_DELIVERY";

            default:
                if(value > 10 && value < 100) {
                    TGPP_RESERVED = new SmServiceType(value);
                    return  "TGPP_RESERVED";
                }
                if (value > 99 && value < 200) {
                    VENDOR_SPECIFIC = new SmServiceType(value);
                    return  "VENDOR_SPECIFIC";
                }
                return "<Invalid Value>";
        }
    }

    private Object readResolve() throws StreamCorruptedException {
        try {
            return fromInt(value);
        } catch (IllegalArgumentException iae) {
            throw new StreamCorruptedException("Invalid internal state found: " + value);
        }
    }

    private int value = 0;

}
