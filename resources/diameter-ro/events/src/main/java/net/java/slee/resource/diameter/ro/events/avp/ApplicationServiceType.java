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
 * Java class to represent the ApplicationServiceType enumerated type.
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class ApplicationServiceType implements Enumerated, java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static final int _SENDING = 100;
    public static final int _RECEIVING = 101;
    public static final int _RETRIEVAL = 102;
    public static final int _INVITING = 103;
    public static final int _LEAVING = 104;
    public static final int _JOINING = 105;

    public static final ApplicationServiceType SENDING = new ApplicationServiceType(_SENDING);
    public static final ApplicationServiceType RECEIVING = new ApplicationServiceType(_RECEIVING);
    public static final ApplicationServiceType RETRIEVAL = new ApplicationServiceType(_RETRIEVAL);
    public static final ApplicationServiceType INVITING = new ApplicationServiceType(_INVITING);
    public static final ApplicationServiceType LEAVING = new ApplicationServiceType(_LEAVING);
    public static final ApplicationServiceType JOINING = new ApplicationServiceType(_JOINING);

    private ApplicationServiceType(int v) {
        value = v;
    }

    /**
     * Return the value of this instance of this enumerated type.
     */
    public static ApplicationServiceType fromInt(int type) {
        switch (type) {
            case _SENDING:
                return SENDING;
            case _RECEIVING:
                return RECEIVING;
            case _RETRIEVAL:
                return RETRIEVAL;
            case _INVITING:
                return INVITING;
            case _LEAVING:
                return LEAVING;
            case _JOINING:
                return JOINING;

            default:
                throw new IllegalArgumentException("Invalid ApplicationServiceType value: " + type);
        }
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        switch (value) {
            case _SENDING:
                return "SENDING";
            case _RECEIVING:
                return "RECEIVING";
            case _RETRIEVAL:
                return "RETRIEVAL";
            case _INVITING:
                return "INVITING";
            case _LEAVING:
                return "LEAVING";
            case _JOINING:
                return "JOINING";

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
