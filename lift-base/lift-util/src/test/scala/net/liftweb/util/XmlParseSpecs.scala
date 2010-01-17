/*
 * Copyright 2007-2010 WorldWide Conferencing, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package net.liftweb.util

import _root_.org.specs._
import _root_.org.specs.runner._
import common._

class ToXmlParseTest extends JUnit4(XmlParseSpecs)
object XmlParseSpecs extends Specification {
  "Multiple attributes with same name, but different namespace" should {
    "parse correctly" >> {
      val actual =
      <lift:surround with="base" at="body">
        <lift:Menu.builder  li_path:class="p" li_item:class="i"/>
      </lift:surround>

      val expected =
      <lift:surround with="base" at="body">
        <lift:Menu.builder  li_path:class="p" li_item:class="i"/>
      </lift:surround>

      import _root_.java.io.ByteArrayInputStream
      val bis = new ByteArrayInputStream(actual.toString.getBytes("UTF-8"))
      val parsed = PCDataXmlParser(bis).open_!
      parsed must ==/(expected)
    }

  }

}

