<template>
    <div id="header">
        <div class="logo">
            <span class="icon fa-gem"></span>
        </div>
        <div class="content">
            <div class="inner">
                <h1>Dimension</h1>
                <p>A fully responsive site template designed by <a href="https://html5up.net">HTML5 UP</a> and released<br />
                for free under the <a href="https://html5up.net/license">Creative Commons</a> license.</p>
            </div>
        </div>
        <nav>
            <ul>
                <li><a href="#Spring">Spring</a></li>
                <li><a href="#Summer">Summer</a></li>
                <li><a href="#Autumn">Autumn</a></li>
                <li><a href="#Winter">Winter</a></li>
                <!--<li><a href="#elements">Elements</a></li>-->
            </ul>
        </nav>
	</div>
</template>

<script>
export default {

}
</script>

<style>
#header nav ul {
			display: -moz-flex;
			display: -webkit-flex;
			display: -ms-flex;
			display: flex;
			margin-bottom: 0;
			list-style: none;
			padding-left: 0;
			border: solid 1px #ffffff;
			border-radius: 4px;
		}

			#header nav ul li {
				padding-left: 0;
				border-left: solid 1px #ffffff;
			}

				#header nav ul li:first-child {
					border-left: 0;
				}

				#header nav ul li a {
					display: block;
					min-width: 7.5rem;
					height: 2.75rem;
					line-height: 2.75rem;
					padding: 0 1.25rem 0 1.45rem;
					text-transform: uppercase;
					letter-spacing: 0.2rem;
					font-size: 0.8rem;
					border-bottom: 0;
				}

					#header nav ul li a:hover {
						background-color: rgba(255, 255, 255, 0.075);
					}

					#header nav ul li a:active {
						background-color: rgba(255, 255, 255, 0.175);
					}
</style>