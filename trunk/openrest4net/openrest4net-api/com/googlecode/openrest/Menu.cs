﻿using System;
using System.Collections.Generic;

namespace com.googlecode.openrest
{
    class Menu
    {
        public Menu(IList<Item> items, IList<Tag> tags, IList<Category> categories)
        {
            this.items = items;
            this.tags = tags;
            this.categories = categories;
        }

        /** Empty constructor required for initialization from JSON-encoded string. */
        internal Menu() { }

        public IList<Item> items = new List<Item>();

        public IList<Tag> tags = new List<Tag>();

        public IList<Category> categories = new List<Category>();
    }
}