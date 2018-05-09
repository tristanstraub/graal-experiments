# install.packages("svglite")
# install.packages("ggplot2")
# install.packages("rsvg")

library(svglite)
library(ggplot2)
svglite("plot.svg", width = 10, height = 7)
qplot(mpg, wt, data = mtcars, colour = factor(cyl))
# dev.off()

# render it into a bitmap array
library(rsvg)
bitmap <- rsvg("plot.svg")
dim(bitmap)
## [1] 504 720   4

# write to format
png::writePNG(bitmap, "bitmap.png")
jpeg::writeJPEG(bitmap, "bitmap.jpg", quality = 1)
webp::write_webp(bitmap, "bitmap.webp", quality = 100)
