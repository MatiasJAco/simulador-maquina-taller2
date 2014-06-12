<?xml version="1.0" encoding='ISO-8859-1' ?>
<!DOCTYPE helpset
  PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN"
         "http://java.sun.com/products/javahelp/helpset_1_0.dtd">
 

<helpset version="1.0">
        <title>Ayuda para Editor</title>
        <maps>
                <!-- Pagina por defecto al mostrar la ayuda -->
                <homeID>Introduccion</homeID>
                <!-- Que mapa deseamos -->
                <mapref location="map_file.jhm"/>
        </maps>

        <!-- Las Vistas que deseamos mostrar en la ayuda -->
        <view>
                <name>Tabla Contenidos</name>
                <label>Tabla de contenidos</label>
                <type>javax.help.TOCView</type>
                <image>ContentIco</image>  
                <data>toc.xml</data>
        </view>

<view>
	<name>Buscar</name>
    <label>Buscar</label>
    <type>javax.help.SearchView</type>
    <image>SearchIco</image>  
    <data engine="com.sun.java.help.search.DefaultSearchEngine">
      JavaHelpSearch
    </data>
</view>

<!-- Definicion de la ventana principal de la ayuda-->  
<presentation default="true" displayviews="true" displayviewimages="true">  
	<name>MainWin</name>  
	
	<!-- Dimensiones iniciales -->  
	<size width="820" height="480" />  
	
	<!-- Posicion inicial -->  
	<location x="180" y="125" />  
	
	<!-- Titulo de la ventana -->  
	<title>Help - Ums Code Editor</title>  

	<!-- Definimos la barra de herramientas de la ventana -->  
	<toolbar>  
    	<!-- Permitimos ir a la pagina anterior -->  
        <helpaction image="BackwardIco"> javax.help.BackAction </helpaction>
          
        <!-- Permitimos ir a la pagina siguiente -->  
        <helpaction image="ForwardIco"> javax.help.ForwardAction </helpaction>
          
        <!-- Permitimos imprimir el contenido -->  
        <helpaction image="PrintIco"> javax.help.PrintAction </helpaction>
          
        <!-- Permitimos configurar la impresion -->  
        <helpaction image="PrintSetupIco"> javax.help.PrintSetupAction </helpaction>  
	</toolbar>  
	
</presentation> 
  
</helpset>

