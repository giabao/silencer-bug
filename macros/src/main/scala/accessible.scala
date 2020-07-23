import scala.annotation.StaticAnnotation
import scala.language.experimental.macros

class accessible extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro AccessibleMacro.apply
}

import scala.reflect.macros.whitebox
class AccessibleMacro(val c: whitebox.Context) {
  def apply(annottees: c.Tree*): c.Tree = annottees.head
}
