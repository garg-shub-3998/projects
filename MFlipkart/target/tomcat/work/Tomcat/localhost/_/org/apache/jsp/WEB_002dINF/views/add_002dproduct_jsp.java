/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-11-04 07:33:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_002dproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/../footer.jspf", Long.valueOf(1603862318021L));
    _jspx_dependants.put("/WEB-INF/views/../header.jspf", Long.valueOf(1604403785551L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Todos</title>\r\n");
      out.write("<link href=\"webjars/bootstrap/3.3.6/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".footer {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbottom: 0;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\tbackground-color: #f5f5f5;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".formheding {\r\n");
      out.write("\tfont-size: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form1 {\r\n");
      out.write("\twidth: 60%;\r\n");
      out.write("\tbackground-color: grey;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn1 {\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".jumbotron {\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tbackground-color: yellow;\r\n");
      out.write("\toverflow-x: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("font {\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".signupform {\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tbackground-color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".required {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".td {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("}\r\n");
      out.write("</style>");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction validate(form) {\r\n");
      out.write("\t\tvar name = form.product.value;\r\n");
      out.write("\t\tvar price = form.price.value;\r\n");
      out.write("\t\tvar brand = form.brand.value;\r\n");
      out.write("\r\n");
      out.write("\t\tif (name == \"\") {\r\n");
      out.write("\t\t\tdocument.getElementById(\"name\").innerHTML = \"This field is required\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (price == \"\") {\r\n");
      out.write("\t\t\tdocument.getElementById(\"price\").innerHTML = \"This field is required\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (brand == \"\") {\r\n");
      out.write("\t\t\tdocument.getElementById(\"brand\").innerHTML = \"This field is required\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav class=\"navbar navbar-default\">\r\n");
      out.write("\r\n");
      out.write("\t\t<ul class=\"nav navbar-nav navbar-left\">\r\n");
      out.write("\t\t\t<li><a href=\"/product.ve\"><font>List Product</font></a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<ul class=\"nav navbar-nav navbar-left\">\r\n");
      out.write("\t\t\t<li><a href=\"/logout.do\"><i class=\"fa fa-fw fa-user\"></i><font>Logout</font></a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container form1\">\r\n");
      out.write("\t\t<div class=\"jumbotron\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<p>YOUR NEW Product IS</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form action=\"/add-product.ve\" method=\"post\"\r\n");
      out.write("\t\t\t\tonSubmit=\"return validate(this)\">\r\n");
      out.write("\t\t\t\t<fieldset class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label>Name<span class=\"required\">*</span></label> <span id=\"name\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"text-danger\"></span> <input name=\"product\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control\" /><br>\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t<fieldset class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label>Price<span class=\"required\">*</span></label> <span\r\n");
      out.write("\t\t\t\t\t\tid=\"price\" class=\"text-danger\"></span> <input name=\"price\"\r\n");
      out.write("\t\t\t\t\t\ttype=\"text\" class=\"form-control\" /><br>\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t<fieldset class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label>Brand<span class=\"required\">*</span></label> <span\r\n");
      out.write("\t\t\t\t\t\tid=\"brand\" class=\"text-danger\"></span> <select name=\"brand\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<option></option>\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<font color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"add\" class=\"btn btn-success\"\r\n");
      out.write("\t\t\t\t\tvalue=\"Submit\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"webjars/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"webjars/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/add-product.jsp(58,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/add-product.jsp(58,6) '${brands }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${brands }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/add-product.jsp(58,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("brand");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<option>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${brand }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
