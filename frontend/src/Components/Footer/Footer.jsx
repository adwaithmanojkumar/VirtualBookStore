import { Button, Grid, Typography } from '@mui/material'
import React from 'react'

const Footer = () => {
    return (
        <div>
            <div className='pt-8'><hr/></div>
            <Grid className='bg-black text-center text-white mt-7'
                container
                sx={{ bgcolor: "white", color: "black"}}
            >
                <Grid item xs={12} sm={6} md={3}>
                    <div className='pb-1 text-red-600 italic font-bold font-lato' variant='h6'>{" "}Company{" "}</div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}About</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Blog</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Press</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Jobs</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Partners</Button>
                    </div>
                </Grid>

                <Grid item xs={12} sm={6} md={3}>
                    <div className='pb-1 text-red-600 italic font-bold' variant='h6'>{" "}Solutions{" "}</div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Marketing</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Analytics</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Commerce</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Insights</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Support</Button>
                    </div>
                </Grid>

                <Grid item xs={12} sm={6} md={3}>
                    <div className='pb-1 text-red-600 italic font-bold' variant='h6'>{" "}Documentation{" "}</div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Guides</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}API status</Button>
                    </div>
                </Grid>

                <Grid item xs={12} sm={6} md={3}>
                    <div className='pb-1 text-red-600 italic font-bold' variant='h6'>{" "}Legal{" "}</div>
                    <div>
                        <Button className='pb-1' variant='h6' gutterBottom>{" "}Claim</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Terms</Button>
                    </div>
                    <div>
                        <Button className='pb-1' variant='h6'>{" "}Privacy</Button>
                    </div>
                </Grid>

                <div class="bottom">
                    <div class="disclaimer">
                        <p>
                            <span className='font-bold italic'>Disclaimer</span>: Legal information is not legal advice,
                            <a href="/legal/disclaimer/">read the disclaimer</a>.
                            The information provided on this site is not legal advice, does not constitute a lawyer referral service, and no attorney-client or confidential relationship is or will be formed by use of the site.
                        </p>
                    </div>
                    <div class="social-icons" className='flex justify-center my-2'>
                        <a href="https://www.youtube.com/" rel="nofollow noopener" target="_blank" title="YouTube" aria-label="YouTube">
                            <img src="https://d2g9wbak88g7ch.cloudfront.net/staticimages/youtube.png" class="icon" alt="YouTube" loading="lazy" decoding="async" fetchpriority="low" width="35" height="35" data-purpose="content" />
                        </a>
                        <a href="https://twitter.com/" rel="nofollow noopener" target="_blank" title="Twitter" aria-label="Twitter">
                            <img src="https://www.bookswagon.com/Images/staticimages/twitter.png" class="icon" alt="Twitter" loading="lazy" decoding="async" fetchpriority="low" width="35" height="35" data-purpose="content" />
                        </a>
                        <a href="https://www.facebook.com/" rel="nofollow noopener" target="_blank" title="Facebook" aria-label="Facebook">
                            <img src="https://d2g9wbak88g7ch.cloudfront.net/staticimages/facebook.png" class="icon" alt="Facebook" loading="lazy" decoding="async" fetchpriority="low" width="35" height="35" data-purpose="content" />
                        </a>
                        <a href="https://www.pinterest.com/" rel="nofollow noopener" target="_blank" title="Pinterest" aria-label="Pinterest">
                            <img src="https://d2g9wbak88g7ch.cloudfront.net/staticimages/pinterest.png" class="icon" alt="Pinterest" loading="lazy" decoding="async" fetchpriority="low" width="35" height="35" data-purpose="content" />
                        </a>
                        <a href="https://www.linkedin.com/" rel="nofollow noopener" target="_blank" title="Linkedin" aria-label="Linkedin">
                            <img src="https://d2g9wbak88g7ch.cloudfront.net/staticimages/linkedin.png" class="icon" alt="Linkedin" loading="lazy" decoding="async" fetchpriority="low" width="35" height="35" data-purpose="content" />
                        </a>
                    </div>
                    <div class="copyright">
                        <p>Copyright © 2012 - 2024 TermsFeed<sup>®</sup>. All rights reserved. </p>
                    </div>
                    <div class="terms-lang-switch">
                        <ul class="terms list-inline-w-separator">
                            <li>
                                <a href="/legal/privacy-policy/" title="Privacy Policy">
                                    Privacy Policy
                                </a>
                            </li>
                            <li>
                                <a href="/legal/cookies-policy/" title="Cookies Policy">
                                    Cookies Policy
                                </a>
                            </li>
                            <li>
                                <a href="/legal/terms-of-use/" title="Terms of Use">
                                    Terms of Use
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </Grid >
        </div >
    )
}

export default Footer