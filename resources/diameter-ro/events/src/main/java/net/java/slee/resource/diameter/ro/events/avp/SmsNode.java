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

/**
 * Java class to represent the SmsNode enumerated type.
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class SmsNode implements Enumerated, java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static final int _SMS_ROUTER = 0;
    public static final int _IP_SM_GW = 1;
    public static final int _SMS_ROUTER_AND_IP_SM_GW = 2;

    public static final SmsNode SMS_ROUTER = new SmsNode(_SMS_ROUTER);
    public static final SmsNode IP_SM_GW = new SmsNode(_IP_SM_GW);
    public static final SmsNode SMS_ROUTER_AND_IP_SM_GW = new SmsNode(_SMS_ROUTER_AND_IP_SM_GW);

    private SmsNode(int v) {
        value = v;
    }

    /**
     * Return the value of this instance of this enumerated type.
     */
    public static SmsNode fromInt(int type) {
        switch (type) {
            case _SMS_ROUTER:
                return SMS_ROUTER;
            case _IP_SM_GW:
                return IP_SM_GW;
            case _SMS_ROUTER_AND_IP_SM_GW:
                return SMS_ROUTER_AND_IP_SM_GW;

            default:
                throw new IllegalArgumentException("Invalid SmsNode value: " + type);
        }
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        switch (value) {
            case _SMS_ROUTER:
                return "SMS_ROUTER";
            case _IP_SM_GW:
                return "IP_SM_GW";
            case _SMS_ROUTER_AND_IP_SM_GW:
                return "SMS_ROUTER_AND_IP_SM_GW";
            default:
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
