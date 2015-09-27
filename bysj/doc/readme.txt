1. 创建Maven Project 选择 maven-archetype-webapp
将.settings目录下的org.eclipse.wst.common.project.facet.core.xml修改成如下：
其中java version=1.6, jst.web version=2.5

<?xml version="1.0" encoding="UTF-8"?>
<faceted-project>
  <fixed facet="wst.jsdt.web"/>
  <installed facet="java" version="1.6"/>
  <installed facet="jst.web" version="2.5"/>
  <installed facet="wst.jsdt.web" version="1.0"/>
</faceted-project>
