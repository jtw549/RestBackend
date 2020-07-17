angular.module('previewImageModule', [])
.directive('previewImage', function() {
	return {
		restrict: 'A',
		link: function($scope, $element) {
			//preview image after selecting the file
			$element.on('change', function(e) {
				var file = e.target.files[0],
					fileReader;
				//add file info to the files model
				$scope.files = [];
				
				if(typeof file == 'object') {
					$scope.files.push(file);
					
					//display a preview of the image  
					fileReader = new FileReader();
					fileReader.readAsDataURL(file);
					fileReader.onload = function(e) {
						//console.log(e.target);
						$('.img-src').html('<img src="' + e.target.result + '" />').fadeIn();
					}
				}
			});
		}
	}
})