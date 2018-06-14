
// Markdown to HTML converter
// Usage example : md2html.groovy README.md
// README.md.html will be generated


@Grapes([
      @Grab('org.markdownj:markdownj-core:0.4')
])
import org.markdownj.*

if (args.length ==0) {
    println """Markdown to HTML converter
Usage: md2html.groovy <Markdown filename>"""
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
