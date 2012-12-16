
// Markdown to HTML converter
// Usage example : md2html.groovy README.md
// README.md.html will be generated


@Grapes([
//    @Grab('org.markdownj:markdownj:0.3.0-1.0.2b4')
      @Grab('org.markdownj:markdownj:latest.release')
])
import com.petebevin.markdown.*

if (args.length ==0) {
    println """Markdown to HTML converter
Usage: md2html.groovy <Makrdown filename>"""
    return   
} 
m = new MarkdownProcessor(); 
outputMd =""
inputMd = new File(args[0]).eachLine { line  -> 
   outputMd += line +"\n"
}
String html = m.markdown(outputMd)

println html

htmlFile=new File(args[0]+".html").newWriter()
htmlFile.writeLine(html)
htmlFile.close()

println "Markdown to HTML conversion done! "
