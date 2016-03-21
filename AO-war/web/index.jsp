<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <meta name="keywords" content="THEMELOCK.COM - Private Transport and Car Hire HTML Template" />
        <meta name="description" content="THEMELOCK.COM - Private Transport and Car Hire HTML Template">
        <meta name="author" content="themeenergy.com">

        <title>THEMELOCK.COM - Home</title>

        <link rel="stylesheet" href="css/theme-red.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/animate.css" />
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="images/favicon.ico" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="home">
        <!-- Header -->
        <header class="header" role="banner">
            <div class="wrap">
                <!-- Logo -->
                <div class="logo">
                    <a href="index.html" title="Transfers"><img src="images/transfers.jpg" alt="Transfers" /></a>
                </div>
                <!-- //Logo -->

                <!-- Main Nav -->
                <nav role="navigation" class="main-nav">
                    <ul>
                        <li class="active"><a href="index.html" title="">accueil</a></li>
                        <li><a href="destinations.html" title="Destinations">STR</a>
                            <ul>
                                <li><a href="Servlet?action=lignesSTR" title="Lignes STR">Lignes</a></li>
                                <li><a href="Servlet?action=listReductionsSTR" title="Abonnements STR">Abonnements</a></li>
                            </ul>
                        </li>
                        <li><a href="blog.html" title="Blog">STF</a>
                            <ul>
                                <li><a href="Servlet?action=AfficherLignesSTF" title="Post">Lignes</a></li>
                                <li><a href="Servlet?action=listAbonnementsSTF" title="Post">Abonnements</a></li>
                            </ul>
                        </li>
                        <li><a href="Servlet?action=AfficherQuestionnaire" title="Questionnaires">Questionnaires</a></li>
                        <li><a href="login.jsp" title="Contact">Connexion</a></li>
                       </ul>
                </nav>
                <!-- //Main Nav -->
            </div>
        </header>
        <!-- //Header -->

        <!-- Main -->
        <main class="main" role="main">
            <!-- Intro -->
            <div class="intro">
                <div class="wrap">
                    <div class="textwidget">
                        <h1 class="wow fadeInDown">Need a ride?</h1>
                        <h2 class="wow fadeInUp">You've come to the right place.</h2>
                        <div class="actions">
                            <a href="#services" title="STR" class="btn large white wow fadeInLeft anchor">STR</a>
                            <a href="#booking" title="STF" class="btn large color wow fadeInRight anchor">STF</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- //Intro -->

            <!-- Search -->
            <div class="advanced-search color" id="booking">
                <div class="wrap">
                    <form role="form" action="Servlet" method="post">
                        <!-- Row -->
                        <div class="f-row">
                            <div class="form-group select one-third">
                                <label for="depart">Départ</label>
                                <input type="text" name="depart" id="depart" />
                            </div>
                            <div class="form-group select one-third">
                                <label for="arrivee">Arrivée</label>
                                <input type="text" name="arrivee" id="arrivee" />
                            </div>
                            <div class="one-third">
                                <label>&nbsp;</label>
                                <input type="hidden" name="action" value="rechercherTrajet">
                                <input class="btn large black" type="submit" value="Rechercher"/>
                            </div>
                            
                        </div>					
                    </form>
                </div>
            </div>
            <!-- //Search -->

            <!-- Services iconic -->
            <div class="services iconic white">
                <div class="wrap">
                    <div class="row">
                        <!-- Item -->
                        <div class="one-third wow fadeIn">
                            <span class="circle"><span class="ico pig"></span></span>
                            <h3>Fixed rates</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->

                        <!-- Item -->
                        <div class="one-third wow fadeIn" data-wow-delay=".2s">
                            <span class="circle"><span class="ico lock"></span></span>
                            <h3>Reliable transfers</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->

                        <!-- Item -->
                        <div class="one-third wow fadeIn" data-wow-delay=".4s">
                            <span class="circle"><span class="ico wallet"></span></span>
                            <h3>No booking fees</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->

                        <!-- Item -->
                        <div class="one-third wow fadeIn">
                            <span class="circle"><span class="ico heart"></span></span>
                            <h3>Free cancellation</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->

                        <!-- Item -->
                        <div class="one-third wow fadeIn" data-wow-delay=".2s">
                            <span class="circle"><span class="ico wand"></span></span>
                            <h3>Booking flexibility</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->

                        <!-- Item -->
                        <div class="one-third wow fadeIn" data-wow-delay=".4s">
                            <span class="circle"><span class="ico telephone"></span></span>
                            <h3>24h customer service</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->

                        <!-- Item -->
                        <div class="one-third wow fadeIn">
                            <span class="circle"><span class="ico award"></span></span>
                            <h3>Award winning service</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->

                        <!-- Item -->
                        <div class="one-third wow fadeIn" data-wow-delay=".2s">
                            <span class="circle"><span class="ico clip"></span></span>
                            <h3>Benefits for partners</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->

                        <!-- Item -->
                        <div class="one-third wow fadeIn" data-wow-delay=".4s">
                            <span class="circle"><span class="ico shuttle"></span></span>
                            <h3>Quality vehicles</h3>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy  tinc dolore magna.</p>
                        </div>
                        <!-- //Item -->
                    </div>
                </div>
            </div>
            <!-- //Services iconic -->

            <!-- Call to action -->
            <div class="black cta">
                <div class="wrap">
                    <p class="wow fadeInLeft">Like what you see? Are you ready to stand out? You know what to do.</p>
                    <a href="#" class="btn huge color right wow fadeInRight">Purchase theme</a>
                </div>
            </div>
            <!-- //Call to action -->

            <!-- Services -->
            <div class="services boxed white" id="services">
                <!-- Item -->
                <article class="one-fourth wow fadeIn">
                    <figure class="featured-image">
                        <img src="http://placehold.it/1024x768" alt="" />
                        <div class="overlay">
                            <a href="services.html" class="expand">+</a>
                        </div>
                    </figure>
                    <div class="details">
                        <h4><a href="services.html">Private transfers</a></h4>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <a class="more" title="Read more" href="services.html">Read more</a>
                    </div>
                </article>
                <!-- //Item -->

                <!-- Item -->
                <article class="one-fourth wow fadeIn" data-wow-delay=".2s">
                    <figure class="featured-image">
                        <img src="http://placehold.it/1024x768" alt="" />
                        <div class="overlay">
                            <a href="services.html" class="expand">+</a>
                        </div>
                    </figure>
                    <div class="details">
                        <h4><a href="services.html">Bus transfers</a></h4>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <a class="more" title="Read more" href="services.html">Read more</a>
                    </div>
                </article>
                <!-- //Item -->

                <!-- Item -->
                <article class="one-fourth wow fadeIn" data-wow-delay=".4s">
                    <figure class="featured-image">
                        <img src="http://placehold.it/1024x768" alt="" />
                        <div class="overlay">
                            <a href="services.html" class="expand">+</a>
                        </div>
                    </figure>
                    <div class="details">
                        <h4><a href="services.html">Shuttle transfers</a></h4>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <a class="more" title="Read more" href="services.html">Read more</a>
                    </div>
                </article>
                <!-- //Item -->

                <!-- Item -->
                <article class="one-fourth wow fadeIn" data-wow-delay=".6s">
                    <figure class="featured-image">
                        <img src="http://placehold.it/1024x768" alt="" />
                        <div class="overlay">
                            <a href="services.html" class="expand">+</a>
                        </div>
                    </figure>
                    <div class="details">
                        <h4><a href="services.html">Helicopter transfers</a></h4>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <a class="more" title="Read more" href="services.html">Read more</a>
                    </div>
                </article>
                <!-- //Item -->			
            </div>
            <!-- //Services -->

            <!-- Testimonials -->
            <div class="testimonials center black">
                <div class="wrap">
                    <h6 class="wow fadeInDown">Wow, this theme is outstanding!</h6>
                    <p class="wow fadeInUp">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <p class="meta wow fadeInUp">-John Doe, themeforest</p>
                </div>
            </div>
            <!-- //Testimonials -->

            <div class="partners white center">
                <div class="wrap">
                    <h2 class="wow fadeIn">Our partners</h2>
                    <div class="one-fifth wow fadeIn"><a href="#"><img src="http://placehold.it/205x60" alt="" /></a></div>
                    <div class="one-fifth wow fadeIn" data-wow-delay=".2s"><a href="#"><img src="http://placehold.it/205x60" alt="" /></a></div>
                    <div class="one-fifth wow fadeIn" data-wow-delay=".4s"><a href="#"><img src="http://placehold.it/205x60" alt="" /></a></div>
                    <div class="one-fifth wow fadeIn" data-wow-delay=".6s"><a href="#"><img src="http://placehold.it/205x60" alt="" /></a></div>
                    <div class="one-fifth" data-wow-delay=".8s"><a href="#"><img src="http://placehold.it/205x60" alt="" /></a></div>
                </div>
            </div>


            <!-- Call to action -->
            <div class="color cta">
                <div class="wrap">
                    <p class="wow fadeInLeft">Like what you see? Are you ready to stand out? You know what to do.</p>
                    <a href="#" class="btn huge black right wow fadeInRight">Purchase theme</a>
                </div>
            </div>
            <!-- //Call to action -->
        </main>
        <!-- //Main -->

        <!-- Footer -->
        <footer class="footer black" role="contentinfo">
            <div class="wrap">
                <div class="row">
                    <!-- Column -->
                    <article class="one-half">
                        <h6>About us</h6>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
                    </article>
                    <!-- //Column -->

                    <!-- Column -->
                    <article class="one-fourth">
                        <h6>Need help?</h6>
                        <p>Contact us via phone or email:</p>
                        <p class="contact-data"><span class="ico phone"></span> +1 555 555 555</p>
                        <p class="contact-data"><span class="ico email"></span> <a href="mailto:help@transfers.com">help@transfers.com</a></p>
                    </article>
                    <!-- //Column -->

                    <!-- Column -->
                    <article class="one-fourth">
                        <h6>Follow us</h6>
                        <ul class="social">
                            <li class="facebook"><a href="#" title="facebook">facebook</a></li>
                            <li class="twitter"><a href="#" title="twitter">twitter</a></li>
                            <li class="gplus"><a href="#" title="gplus">google plus</a></li>
                            <li class="linkedin"><a href="#" title="linkedin">linkedin</a></li>
                            <li class="vimeo"><a href="#" title="vimeo">vimeo</a></li>
                            <li class="pinterest"><a href="#" title="pinterest">pinterest</a></li>
                        </ul>
                    </article>
                    <!-- //Column -->
                </div>

                <div class="copy">
                    <p>Copyright 2014, Themeenergy. All rights reserved. </p>

                    <nav role="navigation" class="foot-nav">
                        <ul>
                            <li><a href="#" title="Home">Home</a></li>
                            <li><a href="#" title="Blog">Blog</a></li>
                            <li><a href="#" title="About us">About us</a></li>
                            <li><a href="#" title="Contact us">Contact us</a></li>
                            <li><a href="#" title="Terms of use">Terms of use</a></li>
                            <li><a href="#" title="Help">Help</a></li>
                            <li><a href="#" title="For partners">For partners</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </footer>
        <!-- //Footer -->

        <!-- Preloader -->
        <div class="preloader">
            <div id="followingBallsG">
                <div id="followingBallsG_1" class="followingBallsG"></div>
                <div id="followingBallsG_2" class="followingBallsG"></div>
                <div id="followingBallsG_3" class="followingBallsG"></div>
                <div id="followingBallsG_4" class="followingBallsG"></div>
            </div>
        </div>
        <!-- //Preloader -->

        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.uniform.min.js"></script>
        <script src="js/jquery.datetimepicker.js"></script>
        <script src="js/jquery.slicknav.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/search.js"></script>
        <script src="js/scripts.js"></script>

    </body>
</html>