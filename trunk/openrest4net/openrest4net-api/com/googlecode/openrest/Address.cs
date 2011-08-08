﻿using System;
using Newtonsoft.Json;

namespace com.googlecode.openrest
{
    public class Address
    {
        public Address(string city, string street, string number, string apt,
            string floor, string entrance, string comment, LatLng latLng)
        {
            this.city = city;
            this.street = street;
            this.number = number;
            this.apt = apt;
            this.floor = floor;
            this.entrance = entrance;
            this.comment = comment;
            this.latLng = latLng;
        }

        /** Empty constructor required for initialization from JSON-encoded string. */
        public Address() { }

        [JsonIgnore]
        public string StreetAddress
        {
            get
            {
                return street + ' ' + number + ", " + city;
            }
        }

        public string city;
        public string street;
        public string number;
        public string apt;
        public string floor;
        public string entrance;
        public string comment;
        public LatLng latLng;
    }
}